package aristosoft.api.user.service;

import java.util.*;
import java.util.concurrent.*;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import aristosoft.api.email.EmailSender;
import aristosoft.api.response.*;
import aristosoft.api.user.model.*;
import aristosoft.api.user.model.dto.UsuarioDto;
import aristosoft.api.user.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private EmailSender emailSender;
    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper mapper;

    @Override
    public Respuesta register(User request) {

        try {

            Optional<User> existingUser = repository.findByUsername(request.getUsername());

            if (existingUser.isPresent()) {
                return Respuesta.builder().type(RespuestaType.WARNING)
                        .message("El usuario ya esta ocupado")
                        .build();
            }

            String uniqueId = UUID.randomUUID().toString();
            User usuario = User.builder()
                    .username(request.getUsername())
                    .usuEmail(request.getUsuEmail())
                    .password(passwordEncoder.encode(uniqueId))
                    .role(request.getRole())
                    .estado(Status.UPDATE_PASS)
                    .created(request.getFecha())
                    .build();

            repository.save(usuario);

            ExecutorService executorService = Executors.newSingleThreadExecutor();
            executorService.submit(() -> {
                emailSender.enviarCorreo(
                        usuario.getUsuEmail(),
                        "Usuario registrado correctamente",
                        "Esta es su contraseña para poder acceder a nuestra plataforma:" + "<br><br><strong>" + uniqueId
                                + "</strong><br><br>" +
                                "Se recomienda actualizar de manera urgente, para asi no tener inconvenientes de que afecten a su seguridad en el internet.",
                        usuario.getUsername());
            });

            executorService.shutdown();

            return Respuesta.builder().type(RespuestaType.SUCCESS)
                    .message("Usuario creado con exito")
                    .build();

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Respuesta restorePassword(Integer idUsuario) {

        Optional<User> user = repository.findById(idUsuario);

        if (!user.isPresent()) {
            return Respuesta.builder().type(RespuestaType.WARNING)
                    .message("El usuario no esta registrado")
                    .build();
        }

        if (user.get().getEstado() == Status.OFFLINE) {
            return Respuesta.builder().type(RespuestaType.WARNING)
                    .message("Usuario bloqueado, no se puede restablecer la contraseña")
                    .build();
        }

        String uniqueId = UUID.randomUUID().toString();

        User usuario = User.builder()
                .idUsuario(idUsuario)
                .username(user.get().getUsername())
                .password(passwordEncoder.encode(uniqueId))
                .role(user.get().getRole())
                .estado(Status.UPDATE_PASS)
                .created(user.get().getCreated())
                .usuEmail(user.get().getUsuEmail())
                .build();
        repository.save(usuario);

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> {
            emailSender.enviarCorreo(
                    usuario.getUsuEmail(),
                    "Reestablecimiento de contraseña",
                    "Estimad@ esta es su contraseña temporal para poder acceder a nuestra plataforma:"
                            + "<br><br><strong>" + uniqueId
                            +
                            "</strong><br><br>" +
                            "Se recomienda actualizar la misma de manera urgente, para asi no tener inconvenientes de que afecten a su seguridad en el internet.",
                    usuario.getUsername().toUpperCase());
        });

        executorService.shutdown();

        return Respuesta.builder().type(RespuestaType.SUCCESS)
                .message("Contraseña temporal enviada")
                .build();
    }

    @Override
    public Respuesta updatePassword(Integer idUsuario, String password, String newPassword, String newPasswordRepit) {

        if (!newPassword.equals(newPasswordRepit)) {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("Las contraseñas no coinciden")
                    .build();
        }

        try {
            Optional<User> optional = repository.findById(idUsuario);
            if (optional.isPresent()) {
                UserDetails user = optional.get();
                if (user instanceof User) {
                    User usuario = (User) user;
                    // Verificar la contraseña actual
                    if (passwordEncoder.matches(password, usuario.getPassword())) {
                        // Cambiar la contraseña
                        String encodedNewPassword = passwordEncoder.encode(newPassword);
                        usuario.setPassword(encodedNewPassword);
                        usuario.setEstado(Status.ONLINE);
                        repository.save(usuario);

                        ExecutorService executorService = Executors.newSingleThreadExecutor();
                        executorService.submit(() -> {
                            emailSender.enviarCorreo(
                                    usuario.getUsuEmail(),
                                    "Contraseña actualizada exitosamente",
                                    "Estimad@ su contraseña ha sido actualizada exitosamente" +
                                            "<br><br>" +
                                            "Si usted no la actualizo contactase manera urgente, respondiendo este email, asi solucionaremos este evento, para asi no tener inconvenientes de que afecten a su seguridad en el internet.",
                                    usuario.getUsername().toUpperCase());
                        });

                        executorService.shutdown();

                        return Respuesta.builder()
                                .type(RespuestaType.SUCCESS)
                                .message("Contraseña actualizada")
                                .build();
                    } else {
                        return Respuesta.builder()
                                .type(RespuestaType.WARNING)
                                .message("La contraseña actual es incorrecta")
                                .build();
                    }
                }
            }

            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("Usuario no encontrado")
                    .build();
        } catch (DisabledException ex) {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("Usuario sin acceso")
                    .build();
        } catch (BadCredentialsException ex) {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("La contraseña es incorrecta")
                    .build();
        }
    }

    @Override
    public Respuesta getById(Integer idUsuario) {

        Optional<User> usuario = repository.findById(idUsuario);

        if (usuario.isPresent()) {
            UsuarioDto dto = UsuarioDto.builder()
                    .username(usuario.get().getUsername())
                    .role(usuario.get().getRole().toString())
                    .Estado(usuario.get().getEstado().toString())
                    .created(usuario.get().getCreated())
                    .usuEmail(usuario.get().getUsuEmail())
                    .build();

            return Respuesta.builder()
                    .type(RespuestaType.SUCCESS)
                    .content(dto)
                    .build();
        } else {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("Usuario no encontrado")
                    .build();
        }
    }

    @Override
    public Respuesta updateAdmin(UsuarioDto dto) {
        Optional<User> optional = repository.findById(dto.getIdUsuario());

        if (optional.isPresent()) {

            optional.get().setRole(Role.valueOf(dto.getRole()));
            optional.get().setUsuEmail(dto.getUsuEmail());

            repository.save(optional.get());

            return Respuesta.builder()
                    .type(RespuestaType.SUCCESS)
                    .message("Usuario actualizado con exito")
                    .build();
        } else {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("Usuario no encontrado")
                    .build();

        }
    }

    @Override
    public Respuesta updateEstado(String estado, Integer idUsuario) {

        if (idUsuario <= 0 || idUsuario == null) {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("Debe tener un ID el registro")
                    .build();
        }

        if (estado.isEmpty() || estado == null) {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("Debe tener el estado")
                    .build();
        }

        Optional<User> optional = repository.findById(idUsuario);

        if (optional.isPresent()) {

            estado.toLowerCase();

            if (estado.equalsIgnoreCase("online")) {
                optional.get().setEstado(Status.ONLINE);
            }

            if (estado.equalsIgnoreCase("bloqueado")) {
                optional.get().setEstado(Status.OFFLINE);
            }

            repository.save(optional.get());

            return Respuesta.builder()
                    .type(RespuestaType.SUCCESS)
                    .message("Usuario " + optional.get().getEstado().toString().toLowerCase())
                    .build();
        } else {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("Usuario no encontrado")
                    .build();

        }

    }

    @Override
    public Page<UsuarioDto> getAll(Pageable pageable) {
        Page<User> pagina;
        pagina = repository.findAll(pageable);
        if (!pagina.isEmpty()) {
            return pagina.map(usuario -> mapper.map(usuario, UsuarioDto.class));
        } else {
            return null;
        }
    }

}

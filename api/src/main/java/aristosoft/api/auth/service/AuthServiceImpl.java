package aristosoft.api.auth.service;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import aristosoft.api.auth.jwt.JwtService;
import aristosoft.api.email.EmailSender;
import aristosoft.api.employe.model.Employe;
import aristosoft.api.employe.model.EmployeDto;
import aristosoft.api.employe.service.EmployeService;
import aristosoft.api.response.Respuesta;
import aristosoft.api.response.RespuestaType;
import aristosoft.api.user.model.*;
import aristosoft.api.user.model.dto.UsuarioLogin;
import aristosoft.api.user.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    @Autowired
    private EmailSender emailSender;
    private final UsuarioRepository repUsuario;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager auth;
    private final EmployeService empService;

    @Override
    public Respuesta login(String userName, String password) {
        try {
            auth.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
            UserDetails user = repUsuario.findByUsername(userName).orElseThrow(null);
            User usuario = (User) user;

            if (!user.isEnabled()) {
                return Respuesta.builder()
                        .type(RespuestaType.WARNING)
                        .message("Usuario bloqueado")
                        .build();
            }

            String token = jwtService.getToken(user);

            Respuesta empRespuesta = empService.getByEmail(userName);

            if (usuario.getRole() == Role.EMPLOYE||usuario.getRole() == Role.ADMINISTRATOR) {

                EmployeDto employeDto = (EmployeDto) empRespuesta.getContent();
                Employe employe = Employe.builder()
                        .idEmploye(employeDto.getIdEmploye())
                        .photo(employeDto.getPhoto())
                        .fullName(employeDto.getFullName())
                        .build();

                UsuarioLogin userLogin = UsuarioLogin.builder()
                        .idUser(usuario.getIdUsuario())
                        .idEmploye(usuario.getIdUsuario())
                        .status(usuario.getEstado().toString())
                        .role(usuario.getRole().toString())
                        .username(userName)
                        .photo(employe.getPhoto())
                        .fullName(employe.getFullName())
                        .build();

                return Respuesta.builder()
                        .token(token)
                        .userDetails(userLogin)
                        .type(RespuestaType.SUCCESS)
                        .build();
            }

            else if (usuario.getRole() == Role.CUSTOMER) {

                EmployeDto employeDto = (EmployeDto) empRespuesta.getContent();
                Employe employe = Employe.builder()
                        .idEmploye(employeDto.getIdEmploye())
                        .photo(employeDto.getPhoto())
                        .fullName(employeDto.getFullName())
                        .build();

                UsuarioLogin userLogin = UsuarioLogin.builder()
                        .idUser(usuario.getIdUsuario())
                        .idEmploye(usuario.getIdUsuario())
                        .status(usuario.getEstado().toString())
                        .role(usuario.getRole().toString())
                        .username(userName)
                        .photo(employe.getPhoto())
                        .fullName(employe.getFullName())
                        .build();

                return Respuesta.builder()
                        .token(token)
                        .userDetails(userLogin)
                        .type(RespuestaType.SUCCESS)
                        .build();
            } else {
                return Respuesta.builder()
                        .type(RespuestaType.WARNING)
                        .message("Credenciales incorrectas")
                        .build();
            }

        } catch (DisabledException ex) {
            return Respuesta.builder().type(RespuestaType.WARNING)
                    .message("Usuario bloqueado")
                    .build();

        } catch (BadCredentialsException ex) {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("Credenciales incorrectas")
                    .build();
        }
    }

    @Override
    public Respuesta restorePassword(String userName, String email) {
        Optional<User> user = repUsuario.findByUsername(userName);

        if (!user.isPresent()) {
            return Respuesta.builder().type(RespuestaType.WARNING)
                    .message("El usuario no esta registrado")
                    .build();
        }

        if (!user.get().getUsuEmail().equals(email)) {
            return Respuesta.builder().type(RespuestaType.WARNING)
                    .message("El email no pertenece al usuario")
                    .build();
        }

        if (user.get().getEstado() == Status.OFFLINE) {
            return Respuesta.builder().type(RespuestaType.WARNING)
                    .message("Usuario bloqueado, no se puede reestablecer")
                    .build();
        }

        String uniqueId = UUID.randomUUID().toString();

        User usuario = User.builder()
                .idUsuario(user.get().getIdUsuario())
                .username(user.get().getUsername())
                .password(passwordEncoder.encode(uniqueId))
                .role(user.get().getRole())
                .estado(Status.UPDATE_PASS)
                .created(user.get().getCreated())
                .usuEmail(user.get().getUsuEmail())
                .build();
        repUsuario.save(usuario);

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> {
            emailSender.enviarCorreo(
                    usuario.getUsuEmail(),
                    "Reestablecimiento de contraseña",
                    "Estimad@ esta es su contraseña temporal para poder acceder a nuestra plataforma:"
                            + "<br><br><strong>" + uniqueId
                            + "</strong><br><br>"
                            + "Se recomienda actualizar la misma de manera urgente, para asi no tener inconvenientes de que afecten a su seguridad en el internet.",
                    usuario.getUsername().toUpperCase());
        });

        executorService.shutdown();

        return Respuesta.builder().type(RespuestaType.SUCCESS)
                .message("Contraseña temporal enviada")
                .build();
    }

    public static String firstWord(String cadena) {
        String[] palabras = cadena.split(" ");
        if (palabras.length > 0) {
            return palabras[0];
        } else {
            return null;
        }
    }

}

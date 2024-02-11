package aristosoft.api.employe.service;

import java.io.IOException;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import aristosoft.api.cloudinary.employe.FileEmploye;
import aristosoft.api.employe.model.Employe;
import aristosoft.api.employe.model.EmployeDto;
import aristosoft.api.employe.repository.EmployeRepository;
import aristosoft.api.response.*;
import aristosoft.api.user.model.*;
import aristosoft.api.user.service.UsuarioService;
import lombok.*;

@Service
@RequiredArgsConstructor
public class EmployeServiceImpl implements EmployeService {

    @Autowired
    private final EmployeRepository repository;

    @Autowired
    private final UsuarioService userService;

    private final FileEmploye upload;

    @Override
    public Page<Employe> getAll(Pageable pageable) {
        Page<Employe> pagina = repository.findAll(pageable);
        if (pagina.isEmpty()) {
            return null;
        }
        return pagina;
    }

    @Override
    public Respuesta getById(Integer idEmploye) {
        Optional<Employe> employe = repository.findById(idEmploye);
        if (!employe.isPresent()) {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("Registro no encontrado")
                    .build();
        }
        return Respuesta.builder()
                .type(RespuestaType.SUCCESS)
                .content(employe)
                .build();
    }

    @Override
    public Respuesta getByEmail(String email) {
        Optional<Employe> employe = repository.findByEmail(email);
        if (!employe.isPresent()) {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("Registro no encontrado")
                    .build();
        }
        EmployeDto dto = EmployeDto.builder()
                .idEmploye(employe.get().getIdEmploye())
                .fullName(employe.get().getFullName())
                .photo(employe.get().getPhoto())
                .build();
        return Respuesta.builder()
                .type(RespuestaType.SUCCESS)
                .content(dto)
                .build();
    }

    @Override
    public Respuesta save(Employe employe, MultipartFile photo) {

        if (employe.getFullName().isEmpty()) {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("Falta los nombres completos")
                    .build();
        }

        if (employe.getEmail().isEmpty()) {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("Falta el email del empleado")
                    .build();
        }

        if (employe.getDescription().isEmpty()) {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("Debe tener una descripcion")
                    .build();
        }

        if (employe.getPhone().isEmpty()) {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("Debe agregar un numero de telefono")
                    .build();
        }

        if (photo.isEmpty()) {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("Debe agregar una foto de perfil")
                    .build();
        }

        Optional<Employe> optional = repository.findByEmail(employe.getEmail());

        if (optional.isPresent()) {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("No se pudo agregar el empleado")
                    .build();
        }

        try {

            User user = User.builder()
                    .role(Role.EMPLOYE)
                    .usuEmail(employe.getEmail())
                    .username(employe.getEmail())
                    .build();

            Respuesta respuestaUsuario = userService.register(user);

            if (respuestaUsuario.getType() == RespuestaType.SUCCESS) {

                employe.setCreated(employe.getFecha());
                employe.setPhoto(upload.uploadImage(photo, "Employe"));
                repository.save(employe);

                return Respuesta.builder()
                        .type(RespuestaType.SUCCESS)
                        .message("Empleado registrado con exito")
                        .build();
            } else {
                return Respuesta.builder()
                        .type(RespuestaType.WARNING)
                        .message("No se pudo agregar el empleado")
                        .build();
            }

        } catch (IOException e) {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("No se pudo agregar el empleado")
                    .build();
        }
    }

    @Override
    public Respuesta update(Employe employe) {

        if (employe.getIdEmploye() <= 0) {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("Debe tener un id el registro solicitado")
                    .build();
        }

        if (employe.getFullName() == null || employe.getFullName().isEmpty()) {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("Falta los nombres completos")
                    .build();
        }

        if (employe.getDescription() == null || employe.getDescription().isEmpty()) {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("Debe tener una descripción")
                    .build();
        }

        if (employe.getPhone() == null || employe.getPhone().isEmpty()) {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("Debe agregar un número de teléfono")
                    .build();
        }

        // Cerrar el Optional después de verificar si está presente
        Optional<Employe> optional = repository.findById(employe.getIdEmploye());

        if (optional.isPresent()) {
            Employe existingEmploye = optional.get();

            // Asegurarse de que ciertos atributos no sean null antes de la actualización
            employe.setCreated(existingEmploye.getCreated());
            employe.setPhoto(existingEmploye.getPhoto() != null && !existingEmploye.getPhoto().isEmpty()
                    ? existingEmploye.getPhoto()
                    : null);

            repository.save(employe);

            return Respuesta.builder()
                    .type(RespuestaType.SUCCESS)
                    .message("Cambios guardados con éxito")
                    .build();
        } else {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("No existe el registro")
                    .build();
        }
    }

    @Override
    public Respuesta deleteById(Integer idEmploye) {

        Optional<Employe> optional = repository.findById(idEmploye);
        if (!optional.isPresent()) {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("No existe el registro")
                    .build();
        } else {
            try {

                repository.deleteById(idEmploye);
                return Respuesta.builder()
                        .type(RespuestaType.SUCCESS)
                        .message("Registro eliminado con exito")
                        .build();

            } catch (Exception e) {
                return Respuesta.builder()
                        .type(RespuestaType.WARNING)
                        .message("No se pudo eliminar el registro")
                        .build();
            }
        }

    }

    @Override
    public Respuesta updatePhoto(Integer idEmploye, MultipartFile photo) {
        try {
            Optional<Employe> optional = repository.findById(idEmploye);

            if (optional.isPresent()) {
                Employe employe = optional.get();

                if (employe != null) {
                    String existingPhoto = employe.getPhoto();
                    System.out.println(existingPhoto);

                    if (existingPhoto != null && !existingPhoto.isEmpty()) {
                        // Eliminar la foto existente antes de subir la nueva
                        upload.deleteFile(existingPhoto);
                    }

                    // Subir la nueva foto y guardar en la base de datos
                    employe.setPhoto(upload.uploadImage(photo, "Employe"));
                    repository.save(employe);

                    return Respuesta.builder()
                            .message("Imagen actualizada con éxito")
                            .type(RespuestaType.SUCCESS)
                            .build();
                } else {
                    return Respuesta.builder()
                            .message("No se pudo actualizar la foto. Objeto Employe es nulo.")
                            .type(RespuestaType.WARNING)
                            .build();
                }
            } else {
                return Respuesta.builder()
                        .message("No se encontró el registro con el ID proporcionado")
                        .type(RespuestaType.WARNING)
                        .build();
            }

        } catch (Exception e) {
            e.printStackTrace(); // Imprimir la traza de la excepción para obtener más detalles
            return Respuesta.builder()
                    .message("Error al actualizar la foto.")
                    .type(RespuestaType.WARNING)
                    .build();
        }
    }

}

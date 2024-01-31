package aristosoft.api.company.service;

import org.springframework.web.multipart.MultipartFile;

import aristosoft.api.cloudinary.company.FileCompany;
import aristosoft.api.company.model.*;
import aristosoft.api.company.repository.CompanyRepository;
import aristosoft.api.response.*;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private final CompanyRepository repository;
    private final FileCompany upload;

    @Override
    public Respuesta getData() {
        Optional<Company> company = repository.findById(1);

        if (!company.isPresent()) {
            return Respuesta.builder()
                    .message("Los datos de la empresa no existen")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        return Respuesta.builder()
                .content(company.get())
                .type(RespuestaType.SUCCESS)
                .build();
    }

    @Override
    public Respuesta getDataPublic() {
        Optional<Company> company = repository.findById(1);
        if (!company.isPresent()) {
            return Respuesta.builder()
                    .message("Los datos de la empresa no existen")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        CompanyDto dto = CompanyDto.builder()
                .name(company.get().getName())
                .email(company.get().getEmail())
                .logo(company.get().getLogo())
                .phone(company.get().getPhone())
                .address(company.get().getAddress())
                .facebook(company.get().getFacebook())
                .instagram(company.get().getInstagram())
                .tiktok(company.get().getTiktok())
                .whatsapp(company.get().getWhatsapp())
                .build();

        return Respuesta.builder()
                .content(dto)
                .type(RespuestaType.SUCCESS)
                .build();
    }

    @Override
    public Respuesta update(Company request) {

        if (request.getName().isEmpty()) {
            return Respuesta.builder()
                    .message("El nombre de la empresa esta vacio")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        if (request.getEmail().isEmpty()) {
            return Respuesta.builder()
                    .message("El email esta vacio")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        if (request.getPassword().isEmpty()) {
            return Respuesta.builder()
                    .message("La clave del email esta vacia")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        if (request.getPort().isEmpty()) {
            return Respuesta.builder()
                    .message("El puerto del email esta vacio")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        if (request.getPhone().isEmpty()) {
            return Respuesta.builder()
                    .message("El telefono esta vacio")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        if (request.getAddress().isEmpty()) {
            return Respuesta.builder()
                    .message("LA direccion esta vacia")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        if (request.getFacebook().isEmpty()) {
            return Respuesta.builder()
                    .message("La pagina de facebook esta vacia")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        if (request.getInstagram().isEmpty()) {
            return Respuesta.builder()
                    .message("La pagina de instagram esta vacia")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        if (request.getTiktok().isEmpty()) {
            return Respuesta.builder()
                    .message("La pagina de tiktok esta vacia")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        if (request.getWhatsapp().isEmpty()) {
            return Respuesta.builder()
                    .message("El numero de whatsapp esta vacio")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        Optional<Company> optionalCompany = repository.findById(1);

        if (optionalCompany.isPresent()) {
            Company existingCompany = optionalCompany.get();
            request.setIdCompany(1);
            request.setLogo(existingCompany.getLogo());
            repository.save(request);
            return Respuesta.builder()
                    .message("Cambios guardados con exito")
                    .type(RespuestaType.SUCCESS)
                    .build();
        } else {
            request.setIdCompany(1);
            repository.save(request);
            return Respuesta.builder()
                    .message("Datos de la empresa creados")
                    .type(RespuestaType.SUCCESS)
                    .build();
        }

    }

    @Override
    public Respuesta updateLogo(MultipartFile logo) {
        if (logo == null) {
            return Respuesta.builder()
                    .message("Seleccione el logo de la empresa")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        try {
            Optional<Company> optionalCompany = repository.findById(1);

            if (optionalCompany.isPresent()) {
                Company company = optionalCompany.get();

                if (company != null) {
                    if (company.getLogo() != null && company.getLogo().isEmpty()) {
                        company.setLogo(upload.uploadImage(logo, "Company"));
                        repository.save(company);
                    } else {
                        if (company.getLogo() != null) {
                            upload.deleteFile(company.getLogo());
                        }
                        company.setLogo(upload.uploadImage(logo, "Company"));
                        repository.save(company);
                    }

                    return Respuesta.builder()
                            .message("Logo actualizado con éxito")
                            .type(RespuestaType.SUCCESS)
                            .build();
                } else {
                    return Respuesta.builder()
                            .message("No se pudo actualizar el logo")
                            .type(RespuestaType.WARNING)
                            .build();
                }
            } else {
                return Respuesta.builder()
                        .message("No se encontró la empresa con el ID proporcionado")
                        .type(RespuestaType.WARNING)
                        .build();
            }

        } catch (Exception e) {
            System.out.println("No se pudo actualizar el logo " + e);
            return Respuesta.builder()
                    .message("No se pudo actualizar el logo.")
                    .type(RespuestaType.WARNING)
                    .build();
        }
    }

}

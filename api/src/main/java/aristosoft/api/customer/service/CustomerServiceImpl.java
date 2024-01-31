package aristosoft.api.customer.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import aristosoft.api.cloudinary.customer.FileCustomer;
import aristosoft.api.customer.model.Customer;
import aristosoft.api.customer.repository.CustomerRepository;
import aristosoft.api.response.*;
import aristosoft.api.user.model.Role;
import aristosoft.api.user.model.User;
import aristosoft.api.user.service.UsuarioService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private final CustomerRepository repository;

    @Autowired
    private final UsuarioService userService;

    private final FileCustomer upload;

    @Override
    public Page<Customer> getAll(Pageable pageable) {
        Page<Customer> pagina = repository.findAll(pageable);
        if (pagina.isEmpty()) {
            return null;
        }
        return pagina;
    }

    @Override
    public Respuesta getById(Integer idCustomer) {
        Optional<Customer> order = repository.findById(idCustomer);
        if (!order.isPresent()) {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("Registro no encontrado")
                    .build();
        }
        return Respuesta.builder()
                .type(RespuestaType.SUCCESS)
                .content(order)
                .build();
    }

    @Override
    public Respuesta save(Customer customer) {

        if (customer.getFullName().isEmpty()) {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("Falta los nombres completos")
                    .build();
        }

        if (customer.getEmail().isEmpty()) {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("Falta el email")
                    .build();
        }

        if (customer.getPhone().isEmpty()) {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("Debe agregar un numero de telefono")
                    .build();
        }

        if (customer.getAddress().isEmpty()) {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("Debe tener una direccion")
                    .build();
        }

        if (customer.getCountry().isEmpty()) {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("Debe tener un pais")
                    .build();
        }

        if (customer.getZip().isEmpty()) {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("Debe tener un codigo postal")
                    .build();
        }

        customer.setCreated(customer.getFecha());
        repository.save(customer);

        // Enviar al email mensaje de creacion de usuario
        User user = User.builder()
                .role(Role.CUSTOMER)
                .usuEmail(customer.getEmail())
                .username(customer.getEmail())
                .build();

        userService.register(user);

        return Respuesta.builder()
                .type(RespuestaType.SUCCESS)
                .message("Usuario registrado con exito")
                .build();
    }

    @Override
    public Respuesta update(Customer customer) {

        if (customer.getIdCustomer() <= 0) {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("Debe tener un id el registro solicitado")
                    .build();
        }

        if (customer.getFullName().isEmpty()) {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("Falta los nombres completos")
                    .build();
        }

        if (customer.getEmail().isEmpty()) {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("Falta el email")
                    .build();
        }

        if (customer.getPhone().isEmpty()) {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("Debe agregar un numero de telefono")
                    .build();
        }

        if (customer.getAddress().isEmpty()) {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("Debe tener una direccion")
                    .build();
        }

        if (customer.getCountry().isEmpty()) {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("Debe tener un pais")
                    .build();
        }

        if (customer.getZip().isEmpty()) {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("Debe tener un codigo postal")
                    .build();
        }
        // Cerrar el Optional después de verificar si está presente
        Optional<Customer> optional = repository.findById(customer.getIdCustomer());

        if (optional.isPresent()) {
            Customer existingCustomer = optional.get();

            // Asegurarse de que ciertos atributos no sean null antes de la actualización
            customer.setCreated(existingCustomer.getCreated());
            customer.setPhoto(existingCustomer.getPhoto() != null && !existingCustomer.getPhoto().isEmpty()
                    ? existingCustomer.getPhoto()
                    : null);

            repository.save(customer);

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
    public Respuesta deleteById(Integer idCustomer) {
        Optional<Customer> optional = repository.findById(idCustomer);
        if (!optional.isPresent()) {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("No existe el registro")
                    .build();
        } else {
            try {

                repository.deleteById(idCustomer);
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
    public Respuesta updatePhoto(Integer idCustomer, MultipartFile photo) {
        System.out.println(idCustomer);
        Optional<Customer> optional = repository.findById(idCustomer);

        try {
            if (optional.isPresent()) {
                Customer customer = optional.get();

                if (customer != null) {
                    if (photo != null) {
                        if (customer.getPhoto() != null && !customer.getPhoto().isEmpty()) {
                            upload.deleteFile(customer.getPhoto());
                        }
                        customer.setPhoto(upload.uploadImage(photo, "Customer"));
                        repository.save(customer);

                        return Respuesta.builder()
                                .message("Foto actualizada con éxito")
                                .type(RespuestaType.SUCCESS)
                                .build();
                    } else {
                        return Respuesta.builder()
                                .message("El archivo de la foto es nulo o vacío")
                                .type(RespuestaType.WARNING)
                                .build();
                    }
                } else {
                    return Respuesta.builder()
                            .message("No se pudo actualizar la foto. Cliente nulo.")
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
            System.out.println(e);
            return Respuesta.builder()
                    .message("No se pudo actualizar la foto.")
                    .type(RespuestaType.WARNING)
                    .build();
        }
    }

}

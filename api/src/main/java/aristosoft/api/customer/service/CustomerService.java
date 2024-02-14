package aristosoft.api.customer.service;

import java.util.List;

import org.springframework.data.domain.*;
import org.springframework.web.multipart.MultipartFile;

import aristosoft.api.customer.model.Customer;
import aristosoft.api.response.Respuesta;

public interface CustomerService {

    Page<Customer> getAll(Pageable pageable);

    List<Customer> findCustomer(String value);

    Respuesta getById(Integer idCustomer);

    Respuesta getByEmail(String email);

    Respuesta save(Customer request);

    Respuesta update(Customer request);

    Respuesta deleteById(Integer idCustomer);

    Respuesta updatePhoto(Integer idCustomer, MultipartFile photo);
}

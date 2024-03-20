package aristosoft.api.order.service;

import org.springframework.data.domain.*;

import aristosoft.api.order.model.*;
import aristosoft.api.response.Respuesta;

public interface OrderService {

    Page<Order> getAll(Pageable pageable);

    Respuesta getById(Integer idOrder);

    Respuesta getByCode(String code);

    Respuesta createOrder(Integer idCustomer);

    Respuesta addProduct(String orderCode, Integer fkProduct, Integer quantity);

    Respuesta updateStatus(Integer idCustomer, String status);

    Respuesta deleteById(Integer idOrder);

}

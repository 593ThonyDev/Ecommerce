package aristosoft.api.order.service;

import org.springframework.data.domain.*;

import aristosoft.api.order.model.*;
import aristosoft.api.response.Respuesta;
import aristosoft.api.status.OrderStatus;

public interface OrderService {

    Page<Order> getAll(Pageable pageable);

    Respuesta getById(Integer idOrder);

    Respuesta getByCode(String code);

    Respuesta createOrder(Integer idCustomer);

    Respuesta updateProduct(String orderCode, Integer fkProduct, Integer quantity);

    Respuesta addProduct(String orderCode, Integer fkProduct);

    Respuesta deleteProduct(String orderCode, Integer fkProduct);

    Respuesta getOrderByCode(String orderCode, Integer fkCustomer);

    Respuesta getOrderByCustomerAndStatus(Integer customer, OrderStatus status);

    Respuesta getOrderByCodeSuccess(String orderCode, Integer fkCustomer);

    Respuesta updateStatus(Integer idCustomer, String status);

    Respuesta updateStatusOrder(Integer idCustomer, String orderCode);

}

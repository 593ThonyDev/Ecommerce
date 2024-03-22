package aristosoft.api.order.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import aristosoft.api.customer.model.CustomerDto;
import aristosoft.api.order.model.Order;
import aristosoft.api.status.OrderStatus;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    Optional<Order> findByCode(String code);

    Optional<Order> findByStatusAndCustomer(OrderStatus orderStatus, CustomerDto customerDto);
    
    List<Order> getOrderfindByStatusAndCustomer(OrderStatus orderStatus, CustomerDto customerDto);

    Integer countByStatusAndCustomer(OrderStatus status, CustomerDto customerDto);

    void deleteByStatusAndCustomer(OrderStatus status, CustomerDto customerDto);

}

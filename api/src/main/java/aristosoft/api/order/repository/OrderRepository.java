package aristosoft.api.order.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import aristosoft.api.order.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    Optional<Order> findByCode(String code);
}

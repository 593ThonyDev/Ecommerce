package aristosoft.api.orderDetail.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import aristosoft.api.order.model.Order;
import aristosoft.api.orderDetail.model.OrderDetail;
import aristosoft.api.product.model.Product;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {

    Optional<OrderDetail> findByOrderAndProduct(Order orde, Product product);
}

package aristosoft.api.orderDetail.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import aristosoft.api.order.model.Order;
import aristosoft.api.orderDetail.model.OrderDetail;
import aristosoft.api.product.model.Product;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {

    Optional<OrderDetail> findByOrderAndProduct(Order orde, Product product);
    
    List<OrderDetail> findByOrder(Order orde);

    @Query("SELECT SUM(od.price * od.quantity) FROM OrderDetail od WHERE od.order.id = :fkOrder")
    Double calculateOrderTotal(@Param("fkOrder") Integer fkOrder);

}

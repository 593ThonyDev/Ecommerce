package aristosoft.api.orderDetail.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import aristosoft.api.orderDetail.model.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {

    @Query(value = "SELECT SUM(price) FROM OrderDetail WHERE fkOrder = :fkOrder", nativeQuery = true)
    Double getTotalAmountByFkOrder(@Param("fkOrder") Integer fkOrder);
}

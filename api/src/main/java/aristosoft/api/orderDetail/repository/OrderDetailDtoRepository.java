package aristosoft.api.orderDetail.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aristosoft.api.orderDetail.model.OrderDetailDto;

@Repository
public interface OrderDetailDtoRepository extends JpaRepository<OrderDetailDto, Integer> {
    List<OrderDetailDto> findByfkOrder(Integer fkOrder);
}

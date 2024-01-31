package aristosoft.api.orderDetail.service;

import java.util.List;

import aristosoft.api.orderDetail.model.*;
import aristosoft.api.response.Respuesta;

public interface OrderDetailService {

    List<OrderDetailDto> getByFkOrder(Integer fkOrder);

    Respuesta save(OrderDetailRequest request);

    Respuesta update(OrderDetailRequest request);

    Respuesta delete(Integer idOrderDetail);

}

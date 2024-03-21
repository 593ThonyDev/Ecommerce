package aristosoft.api.orderDetail.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import aristosoft.api.product.model.ProductDetail;
import aristosoft.api.status.OrderStatus;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailDto {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double price;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer quantity;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String preference;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    ProductDetail product;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private OrderStatus status;

}

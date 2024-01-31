package aristosoft.api.orderDetail.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orderdetail")
public class OrderDetailRequest {

    @Id
    @Column(name = "iddetail")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer idDetail;

    @Column(name = "fkorder")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer fkOrder;

    @Column(name = "fkproduct")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer fkProduct;

    @Column(name = "price")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double price;

    @Column(name = "quantity")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer quantity;

    @Column(name = "preference")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String preference;
}

package aristosoft.api.orderDetail.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonInclude;

import aristosoft.api.order.model.Order;
import aristosoft.api.product.model.Product;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orderdetail")
public class OrderDetail {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "iddetail")
    Integer idDetail;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "price")
    Double price;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "quantity")
    Integer quantity;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "preference")
    String preference;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ManyToOne
    @JoinColumn(name = "fkorder")
    Order fkOrder;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ManyToOne
    @JoinColumn(name = "fkproduct")
    Product fkProduct;
}

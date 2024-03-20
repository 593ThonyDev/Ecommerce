package aristosoft.api.orderDetail.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonInclude;

import aristosoft.api.order.model.Order;
import aristosoft.api.product.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Integer idDetail;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ManyToOne
    @JoinColumn(name = "fkorder")
    Order order;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ManyToOne
    @JoinColumn(name = "fkproduct")
    Product product;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "price")
    private Double price;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "quantity")
    private Integer quantity;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "preference")
    private String preference;

}

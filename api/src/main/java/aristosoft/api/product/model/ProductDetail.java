package aristosoft.api.product.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class ProductDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "idproduct")
    Integer idProduct;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "name")
    String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "img1")
    String img1;

}

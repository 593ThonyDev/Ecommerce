package aristosoft.api.product.model;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonInclude;

import aristosoft.api.category.model.Category;
import aristosoft.api.employe.model.EmployeDto;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "idproduct")
    Integer idProduct;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "description")
    String description;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "name")
    String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "img1")
    String img1;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "img2")
    String img2;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "img3")
    String img3;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "price")
    Double price;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "stock")
    Integer stock;

    @Column(name = "status")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Enumerated(EnumType.STRING)
    ProductStatus status;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "created")
    ZonedDateTime created;

    public ZonedDateTime getFecha() {
        return ZonedDateTime.now(ZoneId.of("America/Guayaquil"));
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ManyToOne
    @JoinColumn(name = "fkcategory")
    Category category;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ManyToOne
    @JoinColumn(name = "create_by")
    EmployeDto empleado;

}

package aristosoft.api.product.model;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonInclude;

import aristosoft.api.category.model.Category;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Integer idProduct;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    String img1;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    Double price;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    Integer stock;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Enumerated(EnumType.STRING)
    ProductStatus status;
    
    public ZonedDateTime getFecha() {
        return ZonedDateTime.now(ZoneId.of("America/Guayaquil"));
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    Category category;

}

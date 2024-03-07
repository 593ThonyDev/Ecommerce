package aristosoft.api.product.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductSearchDto {
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Integer idProduct;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    String description;
    
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
}

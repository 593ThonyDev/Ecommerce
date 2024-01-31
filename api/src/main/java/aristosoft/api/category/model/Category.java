package aristosoft.api.category.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "category")
public class Category {
 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "idcategory")
    Integer idCategory;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "name")
    String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "img")
    String img;
}

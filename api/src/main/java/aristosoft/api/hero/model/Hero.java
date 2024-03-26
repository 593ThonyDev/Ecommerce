package aristosoft.api.hero.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hero")

public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "idhero")
    Integer idHero;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "slogan")
    String slogan;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "description")
    String description;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "img1")
    String img1;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "img2")
    String img2;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "img3")
    String img3;

}

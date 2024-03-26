package aristosoft.api.about.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "about")

public class About {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "idabout")
    Integer idAbout;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "paragraph1")
    String paragraph1;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "paragraph2")
    String paragraph2;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "paragraph3")
    String paragraph3;

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

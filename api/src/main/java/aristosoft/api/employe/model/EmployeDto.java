package aristosoft.api.employe.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employe")
public class EmployeDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "idemploye")
    Integer idEmploye;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "fullname")
    String fullName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "photo")
    String photo;

}

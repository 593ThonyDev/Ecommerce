package aristosoft.api.employe.model;

import java.time.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employe")
public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "idemploye")
    Integer idEmploye;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "created")
    ZonedDateTime created;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "fullname")
    String fullName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "email")
    String email;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "description")
    String description;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "phone")
    String phone;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "photo")
    String photo;

    public ZonedDateTime getFecha() {
        return ZonedDateTime.now(ZoneId.of("America/Guayaquil")); // Directly create ZonedDateTime
    }

}

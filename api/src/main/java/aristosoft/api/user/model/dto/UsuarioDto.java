package aristosoft.api.user.model.dto;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class UsuarioDto {

    @Id
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "iduser")
    Integer idUsuario;

    @Column(name = "username")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String username;

    @Column(name = "email")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String usuEmail;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "created")
    ZonedDateTime created;

    @Column(name = "role")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String role;

    @Column(name = "status")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String Estado;

}
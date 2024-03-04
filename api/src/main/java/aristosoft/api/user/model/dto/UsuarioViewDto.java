package aristosoft.api.user.model.dto;

import lombok.Data;

import java.time.ZonedDateTime;

import javax.persistence.*;

@Data
@Entity
@Table(name = "userview")
public class UsuarioViewDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer iduser;
    private String username;
    private String role;
    private String status;
    private ZonedDateTime created;
    private String fullname;
    private String photo;
}

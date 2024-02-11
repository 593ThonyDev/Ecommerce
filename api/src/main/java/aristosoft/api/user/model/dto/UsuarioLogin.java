package aristosoft.api.user.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioLogin {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idUser;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idEmploye;
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idCustomer;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    String username;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    String fullName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    String usuEmail;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    String role;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    String status;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    String photo;

}
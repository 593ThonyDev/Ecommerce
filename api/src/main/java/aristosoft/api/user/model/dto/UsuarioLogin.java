package aristosoft.api.user.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioLogin {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    Integer idUser;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    Integer idEmploye;

    @JsonInclude(JsonInclude.Include.NON_NULL)
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
package aristosoft.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Respuesta {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String token;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object content;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object userDetails;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String status;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String trace;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer error;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Enumerated(EnumType.STRING)
    RespuestaType type;

}
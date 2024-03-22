package aristosoft.api.order.model;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;


import com.fasterxml.jackson.annotation.JsonInclude;

import aristosoft.api.status.OrderStatus;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String code;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double ammount;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String email;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "date")
    private ZonedDateTime date;

}

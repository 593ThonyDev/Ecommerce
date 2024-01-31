package aristosoft.api.order.model;

import java.time.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonInclude;

import aristosoft.api.status.OrderStatus;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ordersale")
public class OrderRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "idorder")
    Integer idOrder;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "fkcustomer")
    Integer fkCustomer;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "code")
    String code;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "ammount")
    Double ammount;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "address")
    String address;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "email")
    String email;

    @Column(name = "status")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Enumerated(EnumType.STRING)
    OrderStatus status;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "date")
    ZonedDateTime date;

    public ZonedDateTime getFecha() {
        return ZonedDateTime.now(ZoneId.of("America/Guayaquil")); // Directly create ZonedDateTime
    }

}

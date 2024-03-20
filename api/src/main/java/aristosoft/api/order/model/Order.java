package aristosoft.api.order.model;

import java.time.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonInclude;

import aristosoft.api.customer.model.CustomerDto;
import aristosoft.api.status.OrderStatus;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ordersale")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "idorder")
    private Integer idOrder;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ManyToOne
    @JoinColumn(name = "fkcustomer")
    private CustomerDto customer;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "code")
    private String code;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "ammount")
    private Double ammount;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "address")
    private String address;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "email")
    private String email;

    @Column(name = "status")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "date")
    private ZonedDateTime date;

    // Método para obtener la fecha actual en la zona horaria de America/Guayaquil
    @PrePersist
    public void setDate() {
        this.date = ZonedDateTime.now(ZoneId.of("America/Guayaquil"));
    }
    
}

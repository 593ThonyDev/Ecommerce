package aristosoft.api.customer.model;

import java.time.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "idcustomer")
    Integer idCustomer;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "fullname")
    String fullName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "email")
    String email;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "created")
    ZonedDateTime created;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "photo")
    String photo;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "phone")
    String phone;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "address")
    String address;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "country")
    String country;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "zip")
    String zip;

    public ZonedDateTime getFecha() {
        return ZonedDateTime.now(ZoneId.of("America/Guayaquil")); // Directly create ZonedDateTime
    }
}

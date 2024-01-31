package aristosoft.api.customer.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")

public class CustomerDto {
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
    @Column(name = "photo")
    String photo;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "address")
    String address;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "country")
    String country;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "zip")
    String zip;

}

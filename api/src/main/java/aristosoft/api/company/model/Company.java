package aristosoft.api.company.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "idcompany")
    Integer idCompany;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "name")
    String name;
        
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "email")
    String email;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "password")
    String password;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "port")
    String port;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "host")
    String host;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "logo")
    String logo;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "phone")
    String phone;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "address")
    String address;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "facebook")
    String facebook;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "instagram")
    String instagram;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "tiktok")
    String tiktok;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "whatsapp")
    String whatsapp;
    
}

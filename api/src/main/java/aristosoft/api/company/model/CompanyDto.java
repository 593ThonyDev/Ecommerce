package aristosoft.api.company.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDto {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    Integer idCompany;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String name;
        
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String email;    
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String logo;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    String phone;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String address;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String facebook;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String instagram;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String tiktok;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String whatsapp;
    
}

package aristosoft.api.company.service;

import org.springframework.web.multipart.MultipartFile;

import aristosoft.api.company.model.Company;
import aristosoft.api.response.Respuesta;

public interface CompanyService {

    Respuesta getData();

    Respuesta getDataPublic();

    Respuesta update(Company company);

    Respuesta updateLogo(MultipartFile logo);

}

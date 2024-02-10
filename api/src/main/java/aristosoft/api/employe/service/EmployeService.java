package aristosoft.api.employe.service;

import org.springframework.data.domain.*;
import org.springframework.web.multipart.MultipartFile;

import aristosoft.api.employe.model.Employe;
import aristosoft.api.response.Respuesta;

public interface EmployeService {

    Page<Employe> getAll(Pageable pageable);

    Respuesta getById(Integer idEmploye);

    Respuesta save(Employe request, MultipartFile photo);

    Respuesta update(Employe request);

    Respuesta deleteById(Integer idEmploye);

    Respuesta updatePhoto(Integer idEmploye, MultipartFile photo);

}

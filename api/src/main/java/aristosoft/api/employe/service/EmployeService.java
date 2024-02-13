package aristosoft.api.employe.service;

import java.util.List;

import org.springframework.data.domain.*;
import org.springframework.web.multipart.MultipartFile;

import aristosoft.api.employe.model.Employe;
import aristosoft.api.response.Respuesta;

public interface EmployeService {

    Page<Employe> getAll(Pageable pageable);

    List<Employe> findEmploye(String value);

    Respuesta getById(Integer idEmploye);

    Respuesta getByEmail(String email);

    Respuesta save(Employe request, MultipartFile photo);

    Respuesta update(Employe request);

    Respuesta deleteById(Integer idEmploye);

    Respuesta updatePhoto(Integer idEmploye, MultipartFile photo);

}

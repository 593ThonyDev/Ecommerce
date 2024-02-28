package aristosoft.api.category.service;

import java.util.List;

import org.springframework.data.domain.*;
import org.springframework.web.multipart.MultipartFile;

import aristosoft.api.category.model.Category;
import aristosoft.api.response.Respuesta;

public interface CategoryService {

    Page<Category> getAll(Pageable pageable);

    List<Category> findByName(String value);

    Respuesta getById(Integer idCategory);

    Respuesta save(Category category, MultipartFile photo);

    Respuesta update(Category category, MultipartFile photo);

}

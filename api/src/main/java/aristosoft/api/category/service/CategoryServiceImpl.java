package aristosoft.api.category.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import aristosoft.api.category.model.Category;
import aristosoft.api.category.repository.CategoryRepository;
import aristosoft.api.cloudinary.category.FileCategory;
import aristosoft.api.response.*;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private final CategoryRepository repository;

    private final FileCategory upload;

    @Override
    public Page<Category> getAll(Pageable pageable) {
        Page<Category> pagina = repository.findAll(pageable);
        if (pagina.isEmpty()) {
            return null;
        }
        return pagina;
    }

    @Override
    public List<Category> findByName(String value) {
        List<Category> list = repository.findByPartialName(value);
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    @Override
    public Respuesta getById(Integer idCategory) {
        Optional<Category> employe = repository.findById(idCategory);
        if (!employe.isPresent()) {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("Registro no encontrado")
                    .build();
        }
        return Respuesta.builder()
                .type(RespuestaType.SUCCESS)
                .content(employe)
                .build();
    }

    @Override
    public Respuesta save(Category category, MultipartFile photo) {

        if (category.getName().isEmpty()) {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("Se debe tener un nombre")
                    .build();
        }

        if (photo.isEmpty()) {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("Sebe agregar una imagen")
                    .build();
        }

        try {
            category.setImg(upload.uploadImage(photo, "CategoryProducts"));
            repository.save(category);
            return Respuesta.builder()
                    .type(RespuestaType.SUCCESS)
                    .message("Registro guardado con exito")
                    .build();
        } catch (IOException e) {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("No se pudo realizar los cambios")
                    .build();
        }
    }

    @Override
    public Respuesta update(Category category, MultipartFile photo) {

        if (category == null || category.getIdCategory() <= 0) {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("Debe contener un ID válido")
                    .build();
        }

        if (category.getName() == null || category.getName().isEmpty()) {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("Se debe tener un nombre válido")
                    .build();
        }

        Optional<Category> optional = repository.findById(category.getIdCategory());

        if (!optional.isPresent()) {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("Registro no encontrado")
                    .build();
        }

        try {
            if (photo != null && !photo.isEmpty()) {
                upload.deleteFile(optional.get().getImg());
                category.setImg(upload.uploadImage(photo, "CategoryProducts"));
            } else {
                category.setImg(optional.get().getImg());
            }
            repository.save(category);
            return Respuesta.builder()
                    .type(RespuestaType.SUCCESS)
                    .message("Cambios guardados con éxito")
                    .build();
        } catch (IOException e) {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("No se pudieron realizar los cambios")
                    .build();
        }
    }

}

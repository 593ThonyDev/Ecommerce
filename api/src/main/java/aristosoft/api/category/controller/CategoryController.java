package aristosoft.api.category.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import aristosoft.api.category.model.Category;
import aristosoft.api.category.service.CategoryService;
import aristosoft.api.response.Respuesta;
import aristosoft.api.response.RespuestaType;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping("/list")
    public ResponseEntity<Page<Category>> getAll(Pageable pageable) {
        Page<Category> pagina = service.getAll(pageable);
        if (pagina != null && pagina.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else if (pagina != null) {
            return ResponseEntity.ok(pagina);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/{idCategory}")
    public ResponseEntity<Respuesta> getById(@PathVariable("idCategory") String idCategory) {

        Respuesta response = service.getById(Integer.parseInt(idCategory));

        if (response.getType() == RespuestaType.SUCCESS) {
            return ResponseEntity.ok(Respuesta.builder()
                    .content(response.getContent())
                    .build());
        } else {
            return ResponseEntity.badRequest()
                    .body(Respuesta.builder().type(response.getType())
                            .message(response.getMessage())
                            .build());
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Respuesta> save(
            @RequestParam("nombre") String fullName,
            @RequestParam(name = "photo", required = false) MultipartFile photo) {

        Category category = Category.builder()
                .name(fullName)
                .build();

        Respuesta response = service.save(category, photo);

        if (response.getType() == RespuestaType.SUCCESS) {
            return ResponseEntity.ok(Respuesta.builder()
                    .message(response.getMessage())
                    .build());
        } else {
            return ResponseEntity.badRequest()
                    .body(Respuesta.builder().type(response.getType())
                            .message(response.getMessage())
                            .build());
        }
    }

    @PatchMapping("/update")
    public ResponseEntity<Respuesta> update(
            @RequestParam("idCategoria") String idCategory,
            @RequestParam("nombre") String name,
            @RequestParam(name = "photo", required = false) MultipartFile photo) {

        Category category = Category.builder()
                .idCategory(Integer.parseInt(idCategory))
                .name(name)
                .build();

        Respuesta response = service.update(category, photo);

        if (response.getType() == RespuestaType.SUCCESS) {
            return ResponseEntity.ok(Respuesta.builder()
                    .message(response.getMessage())
                    .build());
        } else {
            return ResponseEntity.badRequest()
                    .body(Respuesta.builder().type(response.getType())
                            .message(response.getMessage())
                            .build());
        }
    }

}

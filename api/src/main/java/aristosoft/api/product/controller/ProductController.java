package aristosoft.api.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import aristosoft.api.product.model.*;
import aristosoft.api.product.service.ProductService;
import aristosoft.api.response.*;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/list")
    public ResponseEntity<Page<ProductDto>> getAll(Pageable pageable) {
        Page<ProductDto> pagina = service.getAll(pageable);
        if (pagina != null && pagina.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else if (pagina != null) {
            return ResponseEntity.ok(pagina);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/search/{searchTerm}")
    public ResponseEntity<List<ProductSearchDto>> searchProduct(@PathVariable("searchTerm") String searchTerm) {
        List<ProductSearchDto> lista = service.search(searchTerm);
        if (lista != null && lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else if (lista != null) {
            return ResponseEntity.ok(lista);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
   
    @GetMapping("/public/category/{searchTerm}")
    public ResponseEntity<Page<ProductDto>> getAllInStockByCategory(@PathVariable("searchTerm") String searchTerm, Pageable pageable) {
        searchTerm = searchTerm.replace("-", " ");
        Page<ProductDto> lista = service.getAllInStockByCategory(searchTerm, pageable);
        if (lista != null && lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else if (lista != null) {
            return ResponseEntity.ok(lista);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/public/search/{searchTerm}")
    public ResponseEntity<List<ProductSearchDto>> searchProductOnline(@PathVariable("searchTerm") String searchTerm) {
        List<ProductSearchDto> lista = service.searchOnline(searchTerm);
        if (lista != null && lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else if (lista != null) {
            return ResponseEntity.ok(lista);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/public/list")
    public ResponseEntity<Page<ProductDto>> getAllInStock(Pageable pageable) {
        Page<ProductDto> pagina = service.getAllInStock(pageable);
        if (pagina != null && pagina.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else if (pagina != null) {
            return ResponseEntity.ok(pagina);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/{idProducto}")
    public ResponseEntity<Respuesta> getById(@PathVariable("idProducto") Integer idProduct) {

        Respuesta response = service.getById(idProduct);

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

    @GetMapping("/public/{idProducto}")
    public ResponseEntity<Respuesta> getByIdInStock(@PathVariable("idProducto") Integer idProduct) {

        Respuesta response = service.getByIdInStock(idProduct);

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
            @RequestParam("categoria") String fkCategory,
            @RequestParam("empleado") String fkCreator,
            @RequestParam("nombre") String name,
            @RequestParam("descripcion") String description,
            @RequestParam("precio") String price,
            @RequestParam("stock") String stock,
            @RequestParam(name = "img1", required = false) MultipartFile img1,
            @RequestParam(name = "img2", required = false) MultipartFile img2,
            @RequestParam(name = "img3", required = false) MultipartFile img3) {

        System.out.println("esta es la categoria " + fkCategory);
        ProductRequest request = ProductRequest.builder()
                .fkCategory(Integer.parseInt(fkCategory))
                .fkCreator(Integer.parseInt(fkCreator))
                .name(name)
                .description(description)
                .price(Double.parseDouble(price))
                .stock(Integer.parseInt(stock))
                .build();

        Respuesta response = service.save(request, img1, img2, img3);

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
            @RequestParam("idProducto") String idProduct,
            @RequestParam("categoria") String fkCategory,
            @RequestParam("empleado") String fkCreator,
            @RequestParam("nombre") String name,
            @RequestParam("descripcion") String description,
            @RequestParam("precio") String price,
            @RequestParam("stock") String stock) {

        ProductRequest request = ProductRequest.builder()
                .idProduct(Integer.parseInt(idProduct))
                .fkCategory(Integer.parseInt(fkCategory))
                .name(name)
                .description(description)
                .price(Double.parseDouble(price))
                .stock(Integer.parseInt(stock))
                .build();

        Respuesta response = service.update(request);

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

    @DeleteMapping("/{idProducto}")
    public ResponseEntity<Respuesta> delete(@PathVariable("idProducto") Integer idProduct) {

        Respuesta response = service.delete(idProduct);

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

    @PatchMapping("/updateImage")
    public ResponseEntity<Respuesta> updateImage(
            @RequestParam("idProducto") String idProduct,
            @RequestParam(name = "img1", required = false) MultipartFile img1,
            @RequestParam(name = "img2", required = false) MultipartFile img2,
            @RequestParam(name = "img3", required = false) MultipartFile img3) {

        Respuesta response = service.updateImage(Integer.parseInt(idProduct), img1, img2, img3);

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

    @PatchMapping("/enableStatus")
    public ResponseEntity<Respuesta> enableStatus(
            @RequestParam("idProducto") String idProduct) {

        Respuesta response = service.enableStatus(Integer.parseInt(idProduct));

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

    @PatchMapping("/disableStatus")
    public ResponseEntity<Respuesta> disableStatus(
            @RequestParam("idProducto") String idProduct) {

        Respuesta response = service.disableStatus(Integer.parseInt(idProduct));

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

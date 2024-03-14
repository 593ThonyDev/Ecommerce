package aristosoft.api.product.service;

import java.util.List;

import org.springframework.data.domain.*;
import org.springframework.web.multipart.MultipartFile;

import aristosoft.api.product.model.*;
import aristosoft.api.response.Respuesta;

public interface ProductService {

    Page<ProductDto> getAll(Pageable pageable);

    Page<ProductDto> getAllInStock(Pageable pageable);

    List<ProductSearchDto> search(String searchTerm);

    Respuesta getById(Integer idProduct);

    Respuesta getByIdInStock(Integer idProduct);

    Respuesta save(ProductRequest request, MultipartFile img1, MultipartFile img2, MultipartFile img3);

    Respuesta update(ProductRequest request);

    Respuesta delete(Integer idProduct);

    Respuesta disableStatus(Integer idProduct);

    Respuesta enableStatus(Integer idProduct);

    Respuesta updateImage(Integer idProduct, MultipartFile img1, MultipartFile img2, MultipartFile img3);

}

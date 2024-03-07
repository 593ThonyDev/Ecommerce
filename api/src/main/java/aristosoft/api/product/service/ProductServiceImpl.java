package aristosoft.api.product.service;

import java.io.IOException;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import aristosoft.api.category.model.Category;
import aristosoft.api.cloudinary.product.FileProduct;
import aristosoft.api.employe.model.EmployeDto;
import aristosoft.api.product.model.*;
import aristosoft.api.product.repository.ProductRepository;
import aristosoft.api.response.*;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    @Autowired
    private final ModelMapper modelMapper;

    private final ProductRepository repository;

    private final FileProduct upload;

    @Override
    public Page<ProductDto> getAll(Pageable pageable) {
        Page<Product> pagina = repository.findAll(pageable);
        if (!pagina.isEmpty()) {
            return pagina.map(product -> modelMapper.map(product, ProductDto.class));
        } else {
            return Page.empty();
        }
    }

    @Override
    public List<ProductSearchDto> search(String searchTerm) {
        String searchValue = "%" + searchTerm + "%";
        List<Product> pagina = repository.findByPartialNameOrPartialDescription(searchValue, searchValue);
        if (!pagina.isEmpty()) {
            return pagina.stream()
                    .map(product -> modelMapper.map(product, ProductSearchDto.class))
                    .collect(Collectors.toList());
        } else {
            return null;
        }
    }

    @Override
    public Page<ProductDto> getAllInStock(Pageable pageable) {
        Page<Product> pagina = repository.findByStatusAndStockGreaterThan(ProductStatus.ONLINE, 0, pageable);
        if (!pagina.isEmpty()) {
            return pagina.map(product -> modelMapper.map(product, ProductDto.class));
        } else {
            return Page.empty();
        }
    }

    @Override
    public Respuesta getById(Integer idProduct) {
        Optional<Product> product = repository.findById(idProduct);
        if (!product.isPresent()) {
            return Respuesta.builder()
                    .message("No se encontro el registro")
                    .type(RespuestaType.WARNING)
                    .build();
        }
        return Respuesta.builder()
                .content(product)
                .type(RespuestaType.SUCCESS)
                .build();
    }

    @Override
    public Respuesta getByIdInStock(Integer idProduct) {
        Optional<Product> product = repository.findById(idProduct);

        if (!product.isPresent()) {
            return Respuesta.builder()
                    .message("No se encontro el registro")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        if (product.get().getStock() <= 0) {
            return Respuesta.builder()
                    .message("Registro no disponible")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        if (product.get().getStatus() != ProductStatus.ONLINE) {
            return Respuesta.builder()
                    .message("Registro no disponible")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        return Respuesta.builder()
                .content(product)
                .type(RespuestaType.SUCCESS)
                .build();
    }

    @Override
    public Respuesta save(ProductRequest request, MultipartFile img1, MultipartFile img2, MultipartFile img3) {

        if (request.getFkCategory() <= 0) {
            return Respuesta.builder()
                    .message("")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        if (request.getFkCreator() <= 0) {
            return Respuesta.builder()
                    .message("")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        if (request.getDescription().isEmpty()) {
            return Respuesta.builder()
                    .message("")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        if (request.getName().isEmpty()) {
            return Respuesta.builder()
                    .message("")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        if (request.getPrice() <= 0) {
            return Respuesta.builder()
                    .message("")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        if (request.getStock() <= 0) {
            return Respuesta.builder()
                    .message("")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        if (img1.isEmpty()) {
            return Respuesta.builder()
                    .message("")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        if (img2.isEmpty()) {
            return Respuesta.builder()
                    .message("")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        if (img3.isEmpty()) {
            return Respuesta.builder()
                    .message("")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        try {
            Product product = Product.builder()
                    .category(Category.builder().idCategory(request.getFkCategory()).build())
                    .empleado(EmployeDto.builder().idEmploye(request.getFkCreator()).build())
                    .description(request.getDescription())
                    .name(request.getName())
                    .price(request.getPrice())
                    .stock(request.getStock())
                    .created(request.getFecha())
                    .status(ProductStatus.CREATED)
                    .img1(upload.uploadImage(img1, "Products"))
                    .img2(upload.uploadImage(img2, "Products"))
                    .img3(upload.uploadImage(img3, "Products"))
                    .build();

            repository.save(product);

            return Respuesta.builder()
                    .message("Producto creado con exito")
                    .type(RespuestaType.SUCCESS)
                    .build();
        } catch (Exception e) {
            return Respuesta.builder()
                    .message("No se pudo guardar el producto")
                    .type(RespuestaType.WARNING)
                    .build();
        }

    }

    @Override
    public Respuesta update(ProductRequest request) {

        if (request.getIdProduct() <= 0) {
            return Respuesta.builder()
                    .message("")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        if (request.getFkCategory() <= 0) {
            return Respuesta.builder()
                    .message("")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        if (request.getDescription().isEmpty()) {
            return Respuesta.builder()
                    .message("")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        if (request.getName().isEmpty()) {
            return Respuesta.builder()
                    .message("")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        if (request.getPrice() <= 0) {
            return Respuesta.builder()
                    .message("")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        if (request.getStock() <= 0) {
            return Respuesta.builder()
                    .message("")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        try {

            Optional<Product> optional = repository.findById(request.getIdProduct());

            if (!optional.isPresent()) {
                return Respuesta.builder()
                        .message("Registro no encontrado")
                        .type(RespuestaType.WARNING)
                        .build();
            }

            optional.get().setCategory(Category.builder().idCategory(request.getFkCategory()).build());
            optional.get().setDescription(request.getDescription());
            optional.get().setName(request.getName());
            optional.get().setPrice(request.getPrice());
            optional.get().setStock(request.getStock());

            repository.save(optional.get());

            return Respuesta.builder()
                    .message("Cambios guardados con exito")
                    .type(RespuestaType.SUCCESS)
                    .build();

        } catch (Exception e) {
            return Respuesta.builder()
                    .message("No se pudo actualizar el registro")
                    .type(RespuestaType.WARNING)
                    .build();
        }
    }

    @Override
    public Respuesta delete(Integer idProduct) {

        Optional<Product> optional = repository.findById(idProduct);

        if (!optional.isPresent()) {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("No existe el registro")
                    .build();
        } else {
            try {
                repository.deleteById(idProduct);
                return Respuesta.builder()
                        .type(RespuestaType.SUCCESS)
                        .message("Registro eliminado con exito")
                        .build();

            } catch (Exception e) {
                return Respuesta.builder()
                        .type(RespuestaType.WARNING)
                        .message("No se pudo eliminar el registro")
                        .build();
            }
        }
    }

    @Override
    public Respuesta updateStatus(Integer idProduct, String status) {
        Optional<Product> optional = repository.findById(idProduct);
        if (optional.isPresent()) {

            Product product = optional.get();
            status.toUpperCase();

            if (status.equalsIgnoreCase("ONLINE")) {
                product.setStatus(ProductStatus.ONLINE);
                repository.save(product);
                return Respuesta.builder()
                        .message("Producto en linea")
                        .type(RespuestaType.SUCCESS)
                        .build();
            } else if (status.equalsIgnoreCase("OFFLINE")) {
                product.setStatus(ProductStatus.OFFLINE);
                repository.save(product);
                return Respuesta.builder()
                        .message("Producto dado de baja")
                        .type(RespuestaType.SUCCESS)
                        .build();
            } else {
                return Respuesta.builder()
                        .type(RespuestaType.WARNING)
                        .message("Estado desconocido")
                        .build();
            }

        } else {
            return Respuesta.builder()
                    .type(RespuestaType.WARNING)
                    .message("El registro no existe")
                    .build();
        }
    }

    @Override
    public Respuesta updateImage(Integer idProduct, MultipartFile img1, MultipartFile img2, MultipartFile img3) {

        Optional<Product> optional = repository.findById(idProduct);

        if (img1 != null && img2 == null && img3 == null) {
            return processImage(img1, optional, Product::getImg1, Product::setImg1);
        } else if (img2 != null && img1 == null && img3 == null) {
            return processImage(img2, optional, Product::getImg2, Product::setImg2);
        } else if (img3 != null && img1 == null && img2 == null) {
            return processImage(img3, optional, Product::getImg3, Product::setImg3);
        } else {
            return Respuesta.builder()
                    .message("Debe agregar una sola imagen a la vez")
                    .type(RespuestaType.WARNING)
                    .build();
        }
    }

    private Respuesta processImage(MultipartFile image, Optional<Product> optional,
            Function<Product, String> getImage,
            BiConsumer<Product, String> setImage) {
        try {
            if (optional.isPresent()) {
                String currentImage = getImage.apply(optional.get());
                if (currentImage != null) {
                    upload.deleteFile(currentImage);
                }
                setImage.accept(optional.get(),
                        upload.uploadImage(image, "Products"));
                repository.save(optional.get());
                return Respuesta.builder()
                        .message("Imagen actualizada con éxito")
                        .type(RespuestaType.SUCCESS)
                        .build();
            } else {
                return Respuesta.builder()
                        .message("No se encontró la información para actualizar la imagen")
                        .type(RespuestaType.WARNING)
                        .build();
            }
        } catch (IOException e) {
            return Respuesta.builder()
                    .message("Hubo un error al guardar la imagen")
                    .type(RespuestaType.WARNING)
                    .build();
        }
    }

}

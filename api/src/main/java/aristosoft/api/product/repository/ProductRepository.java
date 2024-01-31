package aristosoft.api.product.repository;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

import aristosoft.api.product.model.Product;
import aristosoft.api.product.model.ProductStatus;

public interface ProductRepository extends JpaRepository<Product, Integer>{
    Page<Product> findByStatusAndStockGreaterThan(ProductStatus status,Integer cantStock, Pageable pageable);
}

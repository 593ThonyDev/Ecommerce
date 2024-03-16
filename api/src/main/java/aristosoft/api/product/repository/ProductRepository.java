package aristosoft.api.product.repository;

import java.util.List;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;

import aristosoft.api.category.model.Category;
import aristosoft.api.product.model.*;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Page<Product> findByStatusAndStockGreaterThan(ProductStatus status, Integer minStock, Pageable pageable);

    @Query("SELECT e FROM Product e WHERE e.name LIKE ?1 OR e.description LIKE ?2")
    List<Product> findByPartialNameOrPartialDescription(String name, String description);

    @Query("SELECT p FROM Product p WHERE (p.name LIKE %?1% OR p.description LIKE %?2%) AND p.status = ?3 AND p.stock >= ?4")
    List<Product> findByPartialNameOrPartialDescriptionAndStatusAndStockGreaterThanEqual(String name,
            String description, ProductStatus status, int minStock);

    @Query("SELECT p FROM Product p WHERE p.category = ?1 AND p.status = ?2 AND p.stock >= ?3")
    Page<Product> findByCategoryAndStatusAndStockGreaterThanEqual(Category category, ProductStatus status, int minStock,
            Pageable pageable);

}

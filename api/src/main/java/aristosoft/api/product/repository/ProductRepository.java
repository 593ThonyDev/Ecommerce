package aristosoft.api.product.repository;

import java.util.List;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;

import aristosoft.api.product.model.*;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Page<Product> findByStatusAndStockGreaterThan(ProductStatus status, Integer cantStock, Pageable pageable);

    @Query("SELECT e FROM Product e WHERE e.name LIKE ?1 OR e.description LIKE ?2")
    List<Product> findByPartialNameOrPartialDescription(String name, String description);

}

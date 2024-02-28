package aristosoft.api.category.repository;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;

import aristosoft.api.category.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query("SELECT c FROM Category c WHERE c.name LIKE CONCAT('%', :partialName, '%')")
    List<Category> findByPartialName(@Param("partialName") String partialName);

}

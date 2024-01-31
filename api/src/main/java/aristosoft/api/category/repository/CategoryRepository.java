package aristosoft.api.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import aristosoft.api.category.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
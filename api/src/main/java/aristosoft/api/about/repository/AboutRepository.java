package aristosoft.api.about.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import aristosoft.api.about.model.About;

public interface AboutRepository extends JpaRepository<About, Integer> {

}

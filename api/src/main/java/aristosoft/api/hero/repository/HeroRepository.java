package aristosoft.api.hero.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import aristosoft.api.hero.model.Hero;

public interface HeroRepository extends JpaRepository<Hero, Integer>{
    
}

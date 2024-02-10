package aristosoft.api.employe.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import aristosoft.api.employe.model.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Integer> {
    Optional<Employe> findByEmail(String email);
}

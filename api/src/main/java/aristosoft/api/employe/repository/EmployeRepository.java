package aristosoft.api.employe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import aristosoft.api.employe.model.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Integer> {

}

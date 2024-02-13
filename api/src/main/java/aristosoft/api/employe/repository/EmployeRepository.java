package aristosoft.api.employe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import aristosoft.api.employe.model.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Integer> {
    Optional<Employe> findByEmail(String email);

    @Query("SELECT e FROM Employe e WHERE e.fullName LIKE ?1 OR e.email LIKE ?2 OR e.phone LIKE ?3")
    List<Employe> findByPartialFullNameOrPartialEmailOrPartialPhone(String partialFullName, String partialEmail,
            String partialPhone);

}

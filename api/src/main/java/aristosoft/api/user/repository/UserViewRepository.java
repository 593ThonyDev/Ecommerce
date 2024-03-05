package aristosoft.api.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import aristosoft.api.user.model.dto.UsuarioViewDto;

@Repository
public interface UserViewRepository extends JpaRepository<UsuarioViewDto, Long> {
    
    @Query(nativeQuery = true, value = "CALL searchuser(:searchTerm)")
    List<UsuarioViewDto> searchUser(@Param("searchTerm") String searchTerm);

}

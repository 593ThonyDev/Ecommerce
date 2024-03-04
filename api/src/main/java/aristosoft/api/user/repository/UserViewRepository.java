package aristosoft.api.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import aristosoft.api.user.model.dto.UsuarioViewDto;

@Repository
public interface UserViewRepository extends JpaRepository<UsuarioViewDto, Long> {
}

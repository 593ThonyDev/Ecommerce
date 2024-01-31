package aristosoft.api.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import aristosoft.api.user.model.User;

public interface UsuarioRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);

    Optional<User> findByUsuEmail(String usuEmail);

}

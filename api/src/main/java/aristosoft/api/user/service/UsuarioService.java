package aristosoft.api.user.service;

import java.util.List;

import org.springframework.data.domain.*;

import aristosoft.api.response.Respuesta;
import aristosoft.api.user.model.User;
import aristosoft.api.user.model.dto.UsuarioDto;
import aristosoft.api.user.model.dto.UsuarioViewDto;

public interface UsuarioService {

    Respuesta register(User usaurio);

    Respuesta restorePassword(Integer idUsuario);

    Respuesta updatePassword(Integer idUsuario, String password, String newPassword, String newPasswordRepit);

    Respuesta getById(Integer idUsuario);

    Respuesta updateAdmin(UsuarioDto usuarioDto);

    Respuesta updateEstado(String estado, Integer idUsuario);

    Page<UsuarioDto> getAll(Pageable pageable);

    Respuesta selectUsers();

    List<UsuarioViewDto> searchUser(String searchItem);

}

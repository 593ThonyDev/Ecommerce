package aristosoft.api.auth.service;

import aristosoft.api.response.Respuesta;

public interface AuthService {

    Respuesta login(String userName, String password);

    Respuesta restorePassword(String userName, String email);

}

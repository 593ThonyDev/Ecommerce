package aristosoft.api.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import aristosoft.api.auth.service.AuthService;
import aristosoft.api.response.Respuesta;
import aristosoft.api.response.RespuestaType;
import aristosoft.api.user.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    UsuarioRepository repository;

    private final AuthService authService;

    @PostMapping("/api/v1/auth/login")
    public ResponseEntity<Respuesta> login(
            @RequestParam("username") String username,
            @RequestParam("password") String password) {

        Respuesta response = authService.login(username, password);

        if (response.getType() == RespuestaType.SUCCESS) {
            return ResponseEntity.ok(Respuesta.builder()
                    .userDetails(response.getUserDetails())
                    .token(response.getToken())
                    .build());
        } else {
            return ResponseEntity.badRequest()
                    .body(Respuesta.builder().type(response.getType())
                            .message(response.getMessage())
                            .build());
        }

    }

    @PostMapping("/api/v1/auth/restorePassword")
    public ResponseEntity<Respuesta> restorePasswordPublic(
            @RequestParam("username") String username,
            @RequestParam("email") String email) {

        Respuesta response = authService.restorePassword(username, email);

        if (response.getType() == RespuestaType.SUCCESS) {
            return ResponseEntity.ok(Respuesta.builder().type(response.getType())
                    .message(response.getMessage())
                    .build());
        } else {
            return ResponseEntity.badRequest()
                    .body(Respuesta.builder().type(response.getType())
                            .message(response.getMessage())
                            .build());
        }

    }
}

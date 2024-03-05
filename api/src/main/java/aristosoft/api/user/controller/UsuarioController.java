package aristosoft.api.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import aristosoft.api.response.*;
import aristosoft.api.user.model.*;
import aristosoft.api.user.model.dto.*;
import aristosoft.api.user.service.UsuarioService;

@RestController
@RequestMapping("/api/v1/user")
public class UsuarioController {

        @Autowired
        private UsuarioService service;

        @PostMapping("/api/v1/usuario/register")
        public ResponseEntity<Respuesta> register(
                        @RequestParam("username") String username,
                        @RequestParam("role") String role,
                        @RequestParam("usuEmail") String usuEmail) {

                User usuario = User.builder()
                                .username(username)
                                .role(Role.valueOf(role))
                                .usuEmail(usuEmail).build();

                Respuesta response = service.register(usuario);

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

        @PatchMapping("/restorePassword")
        public ResponseEntity<Respuesta> restorePassword(@RequestParam("idUsuario") String idUsuario) {
                Respuesta response = service.restorePassword(Integer.parseInt(idUsuario));
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

        @PatchMapping("/api/v1/usuario/auth/updatePassword")
        public ResponseEntity<Respuesta> updatePassword(
                        @RequestParam("idUsuario") String idUsuario,
                        @RequestParam("password") String password,
                        @RequestParam("newPassword") String newPassword,
                        @RequestParam("newPasswordRepit") String newPasswordRepit) {

                Respuesta response = service.updatePassword(Integer.parseInt(idUsuario), password, newPassword,
                                newPasswordRepit);

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

        @PatchMapping("/updateRole")
        public ResponseEntity<Respuesta> updateRole(@RequestParam("idUsuario") String idUsuario) {

                UsuarioDto usuario = UsuarioDto.builder()
                                .idUsuario(Integer.parseInt(idUsuario))
                                .build();

                Respuesta response = service.updateRole(usuario);

                if (response.getType() == RespuestaType.SUCCESS) {
                        return ResponseEntity.ok(Respuesta.builder()
                                        .message(response.getMessage())
                                        .build());
                } else {
                        return ResponseEntity.badRequest()
                                        .body(Respuesta.builder().type(response.getType())
                                                        .message(response.getMessage())
                                                        .build());
                }
        }

        @PatchMapping("/updateStatus")
        public ResponseEntity<Respuesta> updateEstado(
                        @RequestParam("idUsuario") String idUsuario) {

                Respuesta response = service.updateEstado( Integer.parseInt(idUsuario));
                if (response.getType() == RespuestaType.SUCCESS) {
                        return ResponseEntity.ok(Respuesta.builder()
                                        .message(response.getMessage())
                                        .build());
                } else {
                        return ResponseEntity.badRequest()
                                        .body(Respuesta.builder().type(response.getType())
                                                        .message(response.getMessage())
                                                        .build());
                }
        }

        @GetMapping("/list")
        public ResponseEntity<Respuesta> selectUsers() {
                Respuesta response = service.selectUsers();
                if (response.getType() == RespuestaType.SUCCESS) {
                        return ResponseEntity.ok(Respuesta.builder()
                                        .content(response.getContent())
                                        .build());
                } else {
                        return ResponseEntity.badRequest()
                                        .body(Respuesta.builder().type(response.getType())
                                                        .message(response.getMessage())
                                                        .build());
                }
        }

        @GetMapping("/{idUser}")
        public ResponseEntity<Respuesta> listById(@PathVariable("idUser") String idUsuario) {
                Respuesta response = service.getById(Integer.parseInt(idUsuario));
                if (response.getType() == RespuestaType.SUCCESS) {
                        return ResponseEntity.ok(Respuesta.builder().type(response.getType())
                                        .content(response.getContent())
                                        .message(response.getMessage())
                                        .build());
                } else {
                        return ResponseEntity.badRequest()
                                        .body(Respuesta.builder().type(response.getType())
                                                        .message(response.getMessage())
                                                        .build());
                }
        }

        @GetMapping("/search/{value}")
        public ResponseEntity<List<UsuarioViewDto>> searchEmploye(@PathVariable("value") String value) {
                List<UsuarioViewDto> list = service.searchUser(value);
                if (list != null && list.isEmpty()) {
                        return ResponseEntity.noContent().build();
                } else if (list != null) {
                        return ResponseEntity.ok(list);
                } else {
                        return ResponseEntity.noContent().build();
                }
        }

}

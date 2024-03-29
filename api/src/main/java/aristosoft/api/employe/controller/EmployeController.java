package aristosoft.api.employe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import aristosoft.api.employe.model.Employe;
import aristosoft.api.employe.service.EmployeService;
import aristosoft.api.response.*;

@RestController
@RequestMapping("/api/v1/employe")
public class EmployeController {

    @Autowired
    private EmployeService service;

    @GetMapping("/list")
    public ResponseEntity<Page<Employe>> getAll(Pageable pageable) {
        Page<Employe> pagina = service.getAll(pageable);
        if (pagina != null && pagina.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else if (pagina != null) {
            return ResponseEntity.ok(pagina);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/search/{value}")
    public ResponseEntity<List<Employe>> searchEmploye(@PathVariable("value") String value) {
        List<Employe> list = service.findEmploye(value);
        if (list != null && list.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else if (list != null) {
            return ResponseEntity.ok(list);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/{idEmpleado}")
    public ResponseEntity<Respuesta> getById(@PathVariable("idEmpleado") String idEmpleado) {
        Respuesta response = service.getById(Integer.parseInt(idEmpleado));

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

    @DeleteMapping("/{idEmploye}")
    public ResponseEntity<Respuesta> deleteById(@PathVariable("idEmploye") String idEmploye) {

        Respuesta response = service.deleteById(Integer.parseInt(idEmploye));

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

    @PostMapping("/save")
    public ResponseEntity<Respuesta> save(
            @RequestParam("nombres") String fullName,
            @RequestParam("email") String email,
            @RequestParam("descripcion") String description,
            @RequestParam("telefono") String phone,
            @RequestParam(name = "photo", required = false) MultipartFile photo) {

        Employe employe = Employe.builder()
                .fullName(fullName)
                .description(description)
                .email(email)
                .phone(phone)
                .build();

        Respuesta response = service.save(employe, photo);

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

    @PatchMapping("/update")
    public ResponseEntity<Respuesta> update(
            @RequestParam("idEmpleado") String idEmploye,
            @RequestParam("nombres") String fullName,
            @RequestParam("email") String email,
            @RequestParam("descripcion") String description,
            @RequestParam("telefono") String phone) {

        Employe employe = Employe.builder()
                .idEmploye(Integer.parseInt(idEmploye))
                .fullName(fullName)
                .description(description)
                .email(email)
                .phone(phone)
                .build();

        Respuesta response = service.update(employe);

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

    @PatchMapping("/updatePhoto")
    public ResponseEntity<Respuesta> updateFotoPerfil(
            @RequestParam("idEmpleado") String idEmploye,
            @RequestParam(name = "photo", required = false) MultipartFile photo) {

        Respuesta response = service.updatePhoto(Integer.parseInt(idEmploye), photo);

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
}

package aristosoft.api.company.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import aristosoft.api.company.model.Company;
import aristosoft.api.company.service.CompanyService;
import aristosoft.api.response.*;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/company")
public class CompanyController {

    private final CompanyService service;

    @GetMapping("/list")
    public ResponseEntity<Respuesta> getData() {
        Respuesta response = service.getData();

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

    @GetMapping("/public/list")
    public ResponseEntity<Respuesta> getDataPublic() {
        Respuesta response = service.getDataPublic();

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

    @PatchMapping("/update")
    public ResponseEntity<Respuesta> update(
            @RequestParam("nombre") String name,
            @RequestParam("email") String email,
            @RequestParam("clave") String password,
            @RequestParam("puerto") String port,
            @RequestParam("host") String host,
            @RequestParam("telefono") String phone,
            @RequestParam("direccion") String address,
            @RequestParam("facebook") String facebook,
            @RequestParam("instagram") String instagram,
            @RequestParam("tiktok") String tiktok,
            @RequestParam("whatsapp") String whatsapp) {

        Company company = Company.builder()
                .name(name)
                .email(email)
                .password(password)
                .port(port)
                .host(host)
                .phone(phone)
                .address(address)
                .facebook(facebook)
                .instagram(instagram)
                .tiktok(tiktok)
                .whatsapp(whatsapp)
                .build();

        Respuesta response = service.update(company);

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

    @PatchMapping("/updateLogo")
    public ResponseEntity<Respuesta> updateLogo(
            @RequestParam(name = "logo", required = false) MultipartFile logo) {

        Respuesta response = service.updateLogo(logo);

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

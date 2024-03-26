package aristosoft.api.about.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import aristosoft.api.about.model.About;
import aristosoft.api.about.service.AboutService;
import aristosoft.api.response.*;

@RestController
@RequestMapping("/api/v1/about")
public class AboutController {

    @Autowired
    private AboutService service;

    @GetMapping("/hero")
    public ResponseEntity<Respuesta> getDataHero() {

        Respuesta response = service.getDataHero();

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

    @GetMapping("/getData")
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

    @PostMapping("/save")
    public ResponseEntity<Respuesta> save(
            @RequestParam("parrafo1") String parrafo1,
            @RequestParam("parrafo2") String parrafo2,
            @RequestParam("parrafo3") String parrafo3,
            @RequestParam(name = "img1", required = false) MultipartFile img1,
            @RequestParam(name = "img2", required = false) MultipartFile img2,
            @RequestParam(name = "img3", required = false) MultipartFile img3) {

        About hero = About.builder()
                .paragraph1(parrafo1)
                .paragraph2(parrafo2)
                .paragraph3(parrafo3)
                .build();

        Respuesta response = service.save(hero, img1, img2, img3);

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
            @RequestParam("parrafo1") String parrafo1,
            @RequestParam("parrafo2") String parrafo2,
            @RequestParam("parrafo3") String parrafo3) {

        About hero = About.builder()
                .paragraph1(parrafo1)
                .paragraph2(parrafo2)
                .paragraph3(parrafo3)
                .build();

        Respuesta response = service.update(hero);

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

    @PatchMapping("/updateImage")
    public ResponseEntity<Respuesta> updateImage(
            @RequestParam(name = "img1", required = false) MultipartFile img1,
            @RequestParam(name = "img2", required = false) MultipartFile img2,
            @RequestParam(name = "img3", required = false) MultipartFile img3) {

        Respuesta response = service.updateImage(img1, img2, img3);

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

package aristosoft.api.hero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import aristosoft.api.hero.model.Hero;
import aristosoft.api.hero.service.HeroService;
import aristosoft.api.response.*;

@RestController
@RequestMapping("/api/v1/hero")
public class HeroController {

    @Autowired
    private HeroService service;

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
            @RequestParam("slogan") String slogan,
            @RequestParam("description") String description,
            @RequestParam(name = "img1", required = false) MultipartFile img1,
            @RequestParam(name = "img2", required = false) MultipartFile img2,
            @RequestParam(name = "img3", required = false) MultipartFile img3) {

        Hero hero = Hero.builder()
                .slogan(slogan)
                .description(description)
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
            @RequestParam("slogan") String slogan,
            @RequestParam("description") String description) {

        Hero hero = Hero.builder()
                .slogan(slogan)
                .description(description)
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

        Respuesta response = service.updateImage( img1, img2, img3);

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

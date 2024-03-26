package aristosoft.api.hero.service;

import java.io.IOException;
import java.util.*;
import java.util.function.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import aristosoft.api.cloudinary.hero.FileHero;
import aristosoft.api.hero.model.Hero;
import aristosoft.api.hero.repository.HeroRepository;
import aristosoft.api.response.Respuesta;
import aristosoft.api.response.RespuestaType;
import lombok.*;

@Service
@RequiredArgsConstructor
public class HeroServiceImpl implements HeroService {

    @Autowired
    private final HeroRepository repository;
    private final FileHero upload;

    @Override
    public Respuesta save(Hero hero, MultipartFile img1, MultipartFile img2, MultipartFile img3) {

        try {

            Optional<Hero> optional = repository.findById(1);

            if (!optional.isPresent()) {
                // Para crear si no existe el registro y se guarda incluyendo imagenes
                if (hero.getSlogan().isEmpty()) {
                    return Respuesta.builder()
                            .message("Debe agregar el slogan de la empresa")
                            .type(RespuestaType.WARNING)
                            .build();
                }

                if (hero.getDescription().isEmpty()) {
                    return Respuesta.builder()
                            .message("Debe agregar la descripcion de la empresa")
                            .type(RespuestaType.WARNING)
                            .build();
                }

                if (img1.isEmpty()) {
                    return Respuesta.builder()
                            .message("Debe agregar la imagen 1")
                            .type(RespuestaType.WARNING)
                            .build();
                }

                if (img2.isEmpty()) {
                    return Respuesta.builder()
                            .message("Debe agregar la imagen 2")
                            .type(RespuestaType.WARNING)
                            .build();
                }

                if (img3.isEmpty()) {
                    return Respuesta.builder()
                            .message("Debe agregar la imagen 3")
                            .type(RespuestaType.WARNING)
                            .build();
                }

                hero.setImg1(upload.uploadImage(img1, "Hero"));
                hero.setImg2(upload.uploadImage(img2, "Hero"));
                hero.setImg3(upload.uploadImage(img3, "Hero"));
                hero.setIdHero(1);

                repository.save(hero);

                return Respuesta.builder()
                        .message("Datos creados con exito")
                        .type(RespuestaType.SUCCESS)
                        .build();

            } else {
                // Caso contrario solo se guarda el slogan y descripcion
                if (hero.getSlogan().isEmpty()) {
                    return Respuesta.builder()
                            .message("Debe agregar el slogan de la empresa")
                            .type(RespuestaType.WARNING)
                            .build();
                }

                if (hero.getDescription().isEmpty()) {
                    return Respuesta.builder()
                            .message("Debe agregar la descripcion de la empresa")
                            .type(RespuestaType.WARNING)
                            .build();
                }

                repository.save(hero);
                return Respuesta.builder()
                        .message("Cambios guardados con exito")
                        .type(RespuestaType.SUCCESS)
                        .build();
            }

        } catch (IOException e) {
            System.out.println("Error al guardar la imagenes");
            return Respuesta.builder()
                    .message("No se pudo guradar las imagenes")
                    .type(RespuestaType.WARNING)
                    .build();
        }
    }

    @Override
    public Respuesta update(Hero hero) {

        Optional<Hero> optional = repository.findById(1);

        if (!optional.isPresent()) {
            return Respuesta.builder()
                    .message("Debes crear el Hero")
                    .type(RespuestaType.WARNING)
                    .build();

        } else {
            // Caso contrario solo se guarda el slogan y descripcion

            if (hero.getSlogan().isEmpty()) {
                return Respuesta.builder()
                        .message("Debe agregar el slogan de la empresa")
                        .type(RespuestaType.WARNING)
                        .build();
            }

            if (hero.getDescription().isEmpty()) {
                return Respuesta.builder()
                        .message("Debe agregar la descripcion de la empresa")
                        .type(RespuestaType.WARNING)
                        .build();
            }

            optional.get().setSlogan(hero.getSlogan());
            optional.get().setDescription(hero.getDescription());

            repository.save(optional.get());

            return Respuesta.builder()
                    .message("Datos actualizados con exito")
                    .type(RespuestaType.SUCCESS)
                    .build();
        }

    }

    @Override
    public Respuesta updateImage(MultipartFile img1, MultipartFile img2, MultipartFile img3) {
    
        Optional<Hero> optional = repository.findById(1);
    
        if (img1 != null && img2 == null && img3 == null) {
            return processImage(img1, optional, Hero::getImg1, Hero::setImg1);
        } else if (img2 != null && img1 == null && img3 == null) {
            return processImage(img2, optional, Hero::getImg2, Hero::setImg2);
        } else if (img3 != null && img1 == null && img2 == null) {
            return processImage(img3, optional, Hero::getImg3, Hero::setImg3);
        } else {
            return Respuesta.builder()
                    .message("Debe agregar una sola imagen a la vez")
                    .type(RespuestaType.WARNING)
                    .build();
        }
    }
    

    private Respuesta processImage(MultipartFile image, Optional<Hero> optional,
            Function<Hero, String> getImage,
            BiConsumer<Hero, String> setImage) {
        try {
            if (optional.isPresent()) {
                String currentImage = getImage.apply(optional.get());
                if (currentImage != null) {
                    upload.deleteFile(currentImage);
                }
                setImage.accept(optional.get(),
                        upload.uploadImage(image, "Hero"));
                repository.save(optional.get());
                return Respuesta.builder()
                        .message("Imagen actualizada con éxito")
                        .type(RespuestaType.SUCCESS)
                        .build();
            } else {
                return Respuesta.builder()
                        .message("No se encontró la información para actualizar la imagen")
                        .type(RespuestaType.WARNING)
                        .build();
            }
        } catch (IOException e) {
            return Respuesta.builder()
                    .message("Hubo un error al guardar la imagen")
                    .type(RespuestaType.WARNING)
                    .build();
        }
    }

    @Override
    public Respuesta getData() {
        Optional<Hero> hero = repository.findById(1);
        if (!hero.isPresent()) {
            return Respuesta.builder()
                    .message("No se encontró la información")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        hero.get().setIdHero(null);
        return Respuesta.builder()
                .content(hero)
                .type(RespuestaType.SUCCESS)
                .build();
    }

}

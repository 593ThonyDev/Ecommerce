package aristosoft.api.about.service;

import java.io.IOException;
import java.util.Optional;
import java.util.function.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import aristosoft.api.about.model.*;
import aristosoft.api.about.repository.AboutRepository;
import aristosoft.api.cloudinary.about.FileAbout;
import aristosoft.api.response.*;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AboutServiceImpl implements AboutService {

    @Autowired
    private final AboutRepository repository;
    private final FileAbout upload;

    @Override
    public Respuesta getData() {

        Optional<About> optional = repository.findById(1);

        if (!optional.isPresent()) {
            return Respuesta.builder()
                    .message("No existen registros")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        optional.get().setIdAbout(null);
        return Respuesta.builder()
                .content(optional.get())
                .type(RespuestaType.SUCCESS)
                .build();
    }

    @Override
    public Respuesta getDataHero() {

        Optional<About> optional = repository.findById(1);

        if (!optional.isPresent()) {
            return Respuesta.builder()
                    .message("No existen registros")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        About about = About.builder()
                .paragraph1(optional.get().getParagraph1())
                .img1(optional.get().getImg1())
                .build();

        return Respuesta.builder()
                .content(about)
                .type(RespuestaType.SUCCESS)
                .build();
    }

    @Override
    public Respuesta update(About about) {

        if (about.getParagraph1().isEmpty()) {
            return Respuesta.builder()
                    .message("Agregue el contenido en el parrafo 1")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        if (about.getParagraph2().isEmpty()) {
            return Respuesta.builder()
                    .message("Agregue el contenido en el parrafo 2")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        if (about.getParagraph3().isEmpty()) {
            return Respuesta.builder()
                    .message("Agregue el contenido en el parrafo 3")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        Optional<About> optional = repository.findById(1);

        if (!optional.isPresent()) {
            return Respuesta.builder()
                    .message("No existen registros")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        optional.get().setParagraph1(about.getParagraph1());
        optional.get().setParagraph2(about.getParagraph2());
        optional.get().setParagraph3(about.getParagraph3());

        repository.save(optional.get());

        return Respuesta.builder()
                .message("Cambios guardados con exito")
                .type(RespuestaType.SUCCESS)
                .build();
    }

    @Override
    public Respuesta save(About about, MultipartFile img1, MultipartFile img2, MultipartFile img3) {

        if (about.getParagraph1().isEmpty()) {
            return Respuesta.builder()
                    .message("Agregue el contenido en el parrafo 1")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        if (about.getParagraph2().isEmpty()) {
            return Respuesta.builder()
                    .message("Agregue el contenido en el parrafo 2")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        if (about.getParagraph3().isEmpty()) {
            return Respuesta.builder()
                    .message("Agregue el contenido en el parrafo 3")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        if (img1.isEmpty()) {
            return Respuesta.builder()
                    .message("Agregue la imagen 1")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        if (img2.isEmpty()) {
            return Respuesta.builder()
                    .message("Agregue la imagen 2")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        if (img3.isEmpty()) {
            return Respuesta.builder()
                    .message("Agregue la imagen 3")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        Optional<About> optional = repository.findById(1);

        if (!optional.isPresent()) {

            try {

                about.setImg1(upload.uploadImage(img1, "About"));
                about.setImg2(upload.uploadImage(img2, "About"));
                about.setImg3(upload.uploadImage(img3, "About"));
                repository.save(about);
                return Respuesta.builder()
                        .message("Cambios guardados con exito")
                        .type(RespuestaType.SUCCESS)
                        .build();

            } catch (IOException e) {

                return Respuesta.builder()
                        .message("No se pudo guardar el registro!")
                        .type(RespuestaType.WARNING)
                        .build();
            }

        } else {

            return Respuesta.builder()
                    .message("Ya existe el registro!")
                    .type(RespuestaType.WARNING)
                    .build();
        }

    }

    @Override
    public Respuesta updateImage(MultipartFile img1, MultipartFile img2, MultipartFile img3) {

        Optional<About> optional = repository.findById(1);
        if (!optional.isPresent()) {
            return Respuesta.builder()
                    .message("No se existe el registro para actualizar!")
                    .type(RespuestaType.WARNING)
                    .build();
        }

        if (img1 != null && img2 == null && img3 == null) {
            return processImage(img1, optional, About::getImg1, About::setImg1);
        } else if (img2 != null && img1 == null && img3 == null) {
            return processImage(img2, optional, About::getImg2, About::setImg2);
        } else if (img3 != null && img1 == null && img2 == null) {
            return processImage(img3, optional, About::getImg3, About::setImg3);
        } else {
            return Respuesta.builder()
                    .message("Debe agregar una sola imagen a la vez")
                    .type(RespuestaType.WARNING)
                    .build();
        }
    }

    private Respuesta processImage(MultipartFile image, Optional<About> optional,
            Function<About, String> getImage,
            BiConsumer<About, String> setImage) {
        try {
            if (optional.isPresent()) {
                String currentImage = getImage.apply(optional.get());
                if (currentImage != null) {
                    upload.deleteFile(currentImage);
                }
                setImage.accept(optional.get(),
                        upload.uploadImage(image, "About"));
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

}

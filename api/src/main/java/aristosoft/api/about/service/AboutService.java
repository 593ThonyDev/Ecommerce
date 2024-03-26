package aristosoft.api.about.service;

import org.springframework.web.multipart.MultipartFile;

import aristosoft.api.about.model.About;
import aristosoft.api.response.Respuesta;

public interface AboutService {

    Respuesta getData();

    Respuesta getDataHero();

    Respuesta update(About about);

    Respuesta save(About about, MultipartFile img1, MultipartFile img2, MultipartFile img3);

    Respuesta updateImage(MultipartFile img1, MultipartFile img2, MultipartFile img3);

}

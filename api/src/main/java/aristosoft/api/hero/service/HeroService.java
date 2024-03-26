package aristosoft.api.hero.service;

import org.springframework.web.multipart.MultipartFile;

import aristosoft.api.hero.model.Hero;
import aristosoft.api.response.Respuesta;

public interface HeroService {

    Respuesta save(Hero hero, MultipartFile img1, MultipartFile img2, MultipartFile img3);

    Respuesta update(Hero hero);

    Respuesta updateImage(MultipartFile img1, MultipartFile img2, MultipartFile img3);

    Respuesta getData();

}

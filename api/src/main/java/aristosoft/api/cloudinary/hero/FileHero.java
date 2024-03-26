package aristosoft.api.cloudinary.hero;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface FileHero {

    String uploadImage(MultipartFile multipartFile, String folder) throws IOException;

    String deleteFile(String publicId) throws IOException;
}

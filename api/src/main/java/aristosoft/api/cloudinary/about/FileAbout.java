package aristosoft.api.cloudinary.about;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface FileAbout {

    String uploadImage(MultipartFile multipartFile, String folder) throws IOException;

    String deleteFile(String publicId) throws IOException;
}

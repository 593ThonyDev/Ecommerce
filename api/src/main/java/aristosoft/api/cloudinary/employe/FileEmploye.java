package aristosoft.api.cloudinary.employe;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface FileEmploye {

    String uploadImage(MultipartFile multipartFile, String folder) throws IOException;

    String deleteFile(String publicId) throws IOException;
}

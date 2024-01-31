package aristosoft.api.cloudinary.category;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface FileCategory {
    String uploadImage(MultipartFile multipartFile, String folder) throws IOException;

    String deleteFile(String publicId) throws IOException;
}

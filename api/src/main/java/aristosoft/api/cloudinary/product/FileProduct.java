package aristosoft.api.cloudinary.product;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface FileProduct {

    String uploadImage(MultipartFile multipartFile, String folder) throws IOException;

    String deleteFile(String publicId) throws IOException;
}

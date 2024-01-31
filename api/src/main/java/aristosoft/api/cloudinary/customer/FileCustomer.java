package aristosoft.api.cloudinary.customer;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface FileCustomer {

    String uploadImage(MultipartFile multipartFile, String folder) throws IOException;

    String deleteFile(String publicId) throws IOException;
}

package aristosoft.api.cloudinary.company;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface FileCompany {

    String uploadImage(MultipartFile multipartFile, String folder) throws IOException;

    String deleteFile(String publicId) throws IOException;
    
}

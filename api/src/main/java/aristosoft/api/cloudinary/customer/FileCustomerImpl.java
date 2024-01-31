package aristosoft.api.cloudinary.customer;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;

@Service
@RequiredArgsConstructor
public class FileCustomerImpl implements FileCustomer {
    private final Cloudinary cloudinary;

    @Override
    public String uploadImage(MultipartFile multipartFile, String folder) throws IOException {
        if (!esImagen(multipartFile)) {
            return null;
        }

        Map<String, Object> uploadParams = new HashMap<>();
        uploadParams.put("public_id", folder + "/" + UUID.randomUUID().toString());
        String url = eliminarHttp(cloudinary.uploader()
                .upload(multipartFile.getBytes(), uploadParams)
                .get("url")
                .toString());
        return url;
    }

    private static String eliminarHttp(String url) {
        if (url != null && (url.startsWith("https://") || url.startsWith("http://"))) {
            return url.substring(url.indexOf("://") + 3);
        }
        return url;
    }

    private boolean esImagen(MultipartFile file) {
        try {
            BufferedImage image = ImageIO.read(file.getInputStream());
            return image != null;
        } catch (IOException e) {
            // e.printStackTrace();
            return false;
        }
    }

    @Override
    public String deleteFile(String url) {
        if (url == null || url.isEmpty()) {
            return "La URL es nula o vacía";
        }

        String public_id = extractPublicId("https://" + url);

        try {
            @SuppressWarnings("unchecked")
            Map<String, Object> result = cloudinary.uploader().destroy(public_id, ObjectUtils.emptyMap());

            // Verifica si la eliminación fue exitosa
            if (result.get("result").equals("ok")) {
                return "Archivo eliminado exitosamente";
            } else {
                String errorMessage = result.get("message") != null ? result.get("message").toString()
                        : "Mensaje de error no disponible";
                return "Error al eliminar el archivo: " + errorMessage;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return "Error al procesar la URL: " + e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
            return "Error de entrada/salida al eliminar el archivo: " + e.getMessage();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error desconocido al eliminar el archivo: " + e.getMessage();
        }

    }

    public static String extractPublicId(String imageUrl) {
        try {
            URL url = new URL(imageUrl);
            String path = url.getPath();
            String[] pathSegments = path.split("/");
            if (pathSegments.length >= 4) {
                // "Usuarios" es el primer segmento, luego viene el ID de usuario y finalmente
                // el public_id
                String folder = pathSegments[pathSegments.length - 3];
                String userId = pathSegments[pathSegments.length - 2];
                String publicId = pathSegments[pathSegments.length - 1].split("\\.")[0];

                return folder + "/" + userId + "/" + publicId;
            } else {
                return null;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }

}

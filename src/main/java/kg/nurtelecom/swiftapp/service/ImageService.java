package kg.nurtelecom.swiftapp.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    String uploadAvatar(Long developerId, MultipartFile photo);

    Resource getAvatar(Long id);
}

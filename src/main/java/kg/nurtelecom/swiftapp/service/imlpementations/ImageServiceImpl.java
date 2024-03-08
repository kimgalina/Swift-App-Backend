package kg.nurtelecom.swiftapp.service.imlpementations;

import kg.nurtelecom.swiftapp.entity.Developer;
import kg.nurtelecom.swiftapp.exception.FileException;
import kg.nurtelecom.swiftapp.exception.NotFoundException;
import kg.nurtelecom.swiftapp.repository.DeveloperRepository;
import kg.nurtelecom.swiftapp.service.ImageService;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.UUID;

@Service
public class ImageServiceImpl implements ImageService {


    private final DeveloperRepository developerRepository;

    public ImageServiceImpl(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    @Override
    @Transactional
    public String  uploadAvatar(Long developerId, MultipartFile image) {

        if (!image.getContentType().toLowerCase().startsWith("image/")) {
            throw new FileException("Формат изображения не поддерживается");
        }
        Optional<Developer> developer = developerRepository.findById(developerId);
        Developer developerEntity = developer.orElseThrow(() -> new NotFoundException("Пользователя с таким id не существует"));

        try {
            String fileName = "image_" + UUID.randomUUID() + "." + getFileExtension(image);

            Path uploadPath = Paths.get("/home/swift_spring_application/images/");

            File destFile = new File(uploadPath.toFile(), fileName);
            Thumbnails.of(image.getInputStream())
                    .scale(1)
                    .outputQuality(0.5)
                    .toFile(destFile);
            developerEntity.setAvatar(destFile.getPath());
            return destFile.getPath();
        } catch (IOException e) {
            throw new FileException("Ошибка при сохранении изображения");
        }

    }

    private String getFileExtension(MultipartFile file) {
        String originalFileName = file.getOriginalFilename();
        return originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
    }

    @Override
    public Resource getAvatar(Long id) {
        Optional<Developer> developer = developerRepository.findById(id);
        Developer developerEntity = developer.orElseThrow(() -> new NotFoundException("Пользователя с таким id не существует"));

        String avatarPath = developerEntity.getAvatar();
        if(avatarPath == null) {
            throw new NotFoundException("У  пользователя с id = " + id + " нет аватарки");
        }
        Resource resource;
        try {
            Path filePath = Paths.get(avatarPath);
            resource = new UrlResource(filePath.toUri());
            return resource;
        } catch (MalformedURLException e) {
            throw new RuntimeException("Ошибка при чтении изображения");
        }

    }
}

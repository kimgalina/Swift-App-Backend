package kg.nurtelecom.swiftapp.controller;

import kg.nurtelecom.swiftapp.service.ImageService;
import kg.nurtelecom.swiftapp.util.ResponseMessage;
import kg.nurtelecom.swiftapp.util.ResultCode;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    private final ImageService imageService;


    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/{developer_id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseMessage<String> uploadAvatar(@PathVariable("developer_id") Long id,
                                                @RequestPart("photo") MultipartFile photo) {
        return new ResponseMessage<>(
                imageService.uploadAvatar(id, photo),
                ResultCode.SUCCESS
        );
    }

    @GetMapping("/{developer_id}")
    @ResponseStatus(HttpStatus.OK)
    public Resource getAvatar(@PathVariable("developer_id") Long id) {
        return imageService.getAvatar(id);
    }
}

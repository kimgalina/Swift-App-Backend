package kg.nurtelecom.swiftapp.controller.api;

import jakarta.validation.Valid;
import kg.nurtelecom.swiftapp.payload.DeveloperSignUpRequest;
import kg.nurtelecom.swiftapp.payload.DeveloperSignUpResponse;
import kg.nurtelecom.swiftapp.service.DeveloperService;
import kg.nurtelecom.swiftapp.util.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/developers")
public class gi DeveloperController {
    private final DeveloperService developerService;

    public DeveloperController(DeveloperService developerService) {
        this.developerService = developerService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseMessage<DeveloperSignUpResponse> signUp (@Valid @RequestBody DeveloperSignUpRequest developerRequest) {
        return developerService.signUp(developerRequest);
    }
}

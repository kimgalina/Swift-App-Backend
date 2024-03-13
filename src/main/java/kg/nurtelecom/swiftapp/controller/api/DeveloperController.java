package kg.nurtelecom.swiftapp.controller.api;

import jakarta.validation.Valid;
import kg.nurtelecom.swiftapp.payload.DeveloperResponse;
import kg.nurtelecom.swiftapp.payload.DeveloperSignUpRequest;
import kg.nurtelecom.swiftapp.payload.DeveloperSignUpResponse;
import kg.nurtelecom.swiftapp.payload.DeveloperUpdateRequest;
import kg.nurtelecom.swiftapp.service.DeveloperService;
import kg.nurtelecom.swiftapp.util.ResponseMessage;
import kg.nurtelecom.swiftapp.util.ResultCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/developers")
public class DeveloperController {
    private final DeveloperService developerService;

    public DeveloperController(DeveloperService developerService) {
        this.developerService = developerService;
    }

    @GetMapping("/{id}")
    public ResponseMessage<DeveloperResponse> getDeveloper(@PathVariable("id") Long devId) {
        return new ResponseMessage<>(
                developerService.getDeveloper(devId),
                ResultCode.SUCCESS
        );
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseMessage<DeveloperSignUpResponse> signUp (@Valid @RequestBody DeveloperSignUpRequest developerRequest) {
        return new ResponseMessage<>(
                developerService.signUp(developerRequest),
                ResultCode.SUCCESS
        );
    }

    @PutMapping("/{id}")
    public ResponseMessage<DeveloperResponse> updateDeveloper(@PathVariable("id") Long developerId,
                                                              @RequestBody @Valid DeveloperUpdateRequest updatedDeveloper) {
        return new ResponseMessage<>(
                developerService.updateDeveloper(developerId, updatedDeveloper),
                ResultCode.SUCCESS
        );
    }

    @DeleteMapping("/{id}")
    public ResponseMessage<Void> deleteDeveloper(@PathVariable("id") Long id) {
       return  developerService.deleteDeveloper(id);
    }
}

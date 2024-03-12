package kg.nurtelecom.swiftapp.controller.mvc;

import jakarta.validation.Valid;
import kg.nurtelecom.swiftapp.model.Developer;
import kg.nurtelecom.swiftapp.payload.DeveloperSignUpRequest;
import kg.nurtelecom.swiftapp.payload.DeveloperSignUpResponse;
import kg.nurtelecom.swiftapp.service.DeveloperService;
import kg.nurtelecom.swiftapp.service.ImageService;
import kg.nurtelecom.swiftapp.util.DeveloperValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("mvcDeveloperController")
@RequestMapping("/developers")
public class DeveloperController {
    private final DeveloperValidator validator;
    private final DeveloperService developerService;
    private final ImageService imageService;

    public DeveloperController(DeveloperValidator validator, DeveloperService developerService, ImageService imageService) {
        this.validator = validator;
        this.developerService = developerService;
        this.imageService = imageService;
    }

    @GetMapping("/form")
    public String getForm(Model model) {
        model.addAttribute("developer", new Developer());
        return "developer-form";
    }

    @PostMapping()
    public String createDeveloper(@ModelAttribute("developer") @Valid Developer developerRequest,
                                  BindingResult bindingResult,
                                  Model model)
    {
        validator.validate(developerRequest, bindingResult);
        if(bindingResult.hasErrors()) {
            return "developer-form";
        }
        DeveloperSignUpRequest developerDTO = new DeveloperSignUpRequest(
                developerRequest.getFirstname(),
                developerRequest.getLastname(),
                developerRequest.getPosition(),
                developerRequest.getPhone(),
                developerRequest.getEmail()
        );
        DeveloperSignUpResponse response = developerService.signUp(developerDTO);
        imageService.uploadAvatar(response.id(), developerRequest.getPhoto());
        model.addAttribute("savedDeveloper", response);

        return "congratulations";
    }
}

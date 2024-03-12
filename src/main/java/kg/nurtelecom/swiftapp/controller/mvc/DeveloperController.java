package kg.nurtelecom.swiftapp.controller.mvc;

import jakarta.validation.Valid;
import kg.nurtelecom.swiftapp.model.Developer;
import org.springframework.security.core.parameters.P;
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
        if(bindingResult.hasErrors()) {
            return "developer-form";
        }
        System.out.println(developerRequest.getFirstname());
        System.out.println(developerRequest.getLastname());
        System.out.println(developerRequest.getEmail());
        return "redirect:/";
    }
}

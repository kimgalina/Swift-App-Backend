package kg.nurtelecom.swiftapp.controller.mvc;


import kg.nurtelecom.swiftapp.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("mvcAuthController")
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/login")
    public String login(@RequestParam(name = "error", required = false) String error, Model model) {
        if(error != null) {
            model.addAttribute("errorMessage", "Неправильное имя пользователя  или пароль");
        }
        model.addAttribute("user", new User());
        return "login";
    }
}

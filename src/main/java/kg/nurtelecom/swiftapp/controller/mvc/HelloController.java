package kg.nurtelecom.swiftapp.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("mvcHelloController")
@RequestMapping("/")
public class HelloController {

    @GetMapping
    public String sayHello() {
        return "hello";
    }
}

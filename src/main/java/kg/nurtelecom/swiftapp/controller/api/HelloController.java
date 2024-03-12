package kg.nurtelecom.swiftapp.controller.api;

import kg.nurtelecom.swiftapp.util.ResponseMessage;
import kg.nurtelecom.swiftapp.util.ResultCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello")
    @ResponseStatus(HttpStatus.OK)
    public ResponseMessage<String> sayHello() {
        return new ResponseMessage<>(
                "Hello from Galina's Backend = )",
                ResultCode.SUCCESS
        );
    }

}

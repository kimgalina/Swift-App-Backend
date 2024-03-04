package kg.nurtelecom.swiftapp.controller;

import kg.nurtelecom.swiftapp.payload.LoginResponse;
import kg.nurtelecom.swiftapp.util.ResponseMessage;
import kg.nurtelecom.swiftapp.util.ResultCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class LoginJsonController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseMessage<LoginResponse> getLoginForm() {
        return new ResponseMessage<>(
                new LoginResponse("username","password","Войти"),
                ResultCode.SUCCESS
        );
    }

}

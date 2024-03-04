package kg.nurtelecom.swiftapp.controller;

import kg.nurtelecom.swiftapp.payload.DeveloperFormResponse;
import kg.nurtelecom.swiftapp.util.ResponseMessage;
import kg.nurtelecom.swiftapp.util.ResultCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/developer")
public class DeveloperJsonController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseMessage<DeveloperFormResponse> getDeveloperForm() {
        return new ResponseMessage<>(
                new DeveloperFormResponse("Имя", "Фамилия", "Должность", "Тел", "email"),
                ResultCode.SUCCESS
        );
    }

}

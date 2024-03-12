package kg.nurtelecom.swiftapp.controller.api;

import jakarta.validation.Valid;
import kg.nurtelecom.swiftapp.payload.UserSignInRequest;
import kg.nurtelecom.swiftapp.payload.UserSignInResponse;
import kg.nurtelecom.swiftapp.service.AuthService;
import kg.nurtelecom.swiftapp.util.ResponseMessage;
import kg.nurtelecom.swiftapp.util.ResultCode;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/sign-in")
    public ResponseMessage<UserSignInResponse> signIn( @Valid @RequestBody UserSignInRequest userRequest) {

        return new ResponseMessage<>(
                authService.signIn(userRequest),
                ResultCode.SUCCESS
        );
    }

}

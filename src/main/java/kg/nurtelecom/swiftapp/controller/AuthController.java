package kg.nurtelecom.swiftapp.controller;

import jakarta.validation.Valid;
import kg.nurtelecom.swiftapp.payload.UserSignInRequest;
import kg.nurtelecom.swiftapp.payload.UserSignInResponse;
import kg.nurtelecom.swiftapp.service.AuthService;
import kg.nurtelecom.swiftapp.util.ResponseMessage;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public ResponseMessage<UserSignInResponse> signIn( @Valid @RequestBody UserSignInRequest userRequest) {
        // логика security
        return null;
    }

}

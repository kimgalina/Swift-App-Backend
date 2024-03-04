package kg.nurtelecom.swiftapp.service;

import kg.nurtelecom.swiftapp.payload.UserSignInRequest;
import kg.nurtelecom.swiftapp.payload.UserSignInResponse;

public interface AuthService {
    UserSignInResponse signIn(UserSignInRequest userRequest);
}

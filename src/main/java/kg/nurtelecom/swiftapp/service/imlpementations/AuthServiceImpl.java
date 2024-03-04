package kg.nurtelecom.swiftapp.service.imlpementations;


import kg.nurtelecom.swiftapp.payload.UserSignInRequest;
import kg.nurtelecom.swiftapp.payload.UserSignInResponse;
import kg.nurtelecom.swiftapp.repository.UserRepository;
import kg.nurtelecom.swiftapp.security.JwtService;
import kg.nurtelecom.swiftapp.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserRepository userRepository;

    public AuthServiceImpl(AuthenticationManager authenticationManager, JwtService jwtService, UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userRepository = userRepository;
    }

    @Override
    public UserSignInResponse signIn(UserSignInRequest userRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userRequest.username(), userRequest.password())
        );

        return new UserSignInResponse(
                jwtService.
                generateToken(userRepository.findByNickname(userRequest.username()).orElseThrow(() -> new UsernameNotFoundException("User with such nickname has not been found")))
        );

    }
}

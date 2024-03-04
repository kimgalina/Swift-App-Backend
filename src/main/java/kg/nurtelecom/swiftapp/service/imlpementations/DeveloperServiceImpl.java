package kg.nurtelecom.swiftapp.service.imlpementations;

import kg.nurtelecom.swiftapp.payload.DeveloperSignUpRequest;
import kg.nurtelecom.swiftapp.payload.DeveloperSignUpResponse;
import kg.nurtelecom.swiftapp.service.DeveloperService;
import kg.nurtelecom.swiftapp.util.ResponseMessage;
import org.springframework.stereotype.Service;

@Service
public class DeveloperServiceImpl implements DeveloperService {

    @Override
    public ResponseMessage<DeveloperSignUpResponse> signUp(DeveloperSignUpRequest developerRequest) {
        return null;
    }
}

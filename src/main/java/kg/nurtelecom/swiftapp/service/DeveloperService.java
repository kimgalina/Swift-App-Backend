package kg.nurtelecom.swiftapp.service;

import kg.nurtelecom.swiftapp.payload.DeveloperSignUpRequest;
import kg.nurtelecom.swiftapp.payload.DeveloperSignUpResponse;
import kg.nurtelecom.swiftapp.util.ResponseMessage;

public interface DeveloperService {
    ResponseMessage<DeveloperSignUpResponse> signUp(DeveloperSignUpRequest developerRequest);
}

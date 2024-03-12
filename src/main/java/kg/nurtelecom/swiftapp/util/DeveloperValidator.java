package kg.nurtelecom.swiftapp.util;

import kg.nurtelecom.swiftapp.model.Developer;
import kg.nurtelecom.swiftapp.repository.DeveloperRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class DeveloperValidator implements Validator {
    private final DeveloperRepository developerRepository;

    public DeveloperValidator(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Developer.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Developer developerRequest = (Developer) target;
        if(developerRepository.findByEmail(developerRequest.getEmail()).isPresent()) {
            errors.rejectValue("email", "", "Разработчик с таким email адресом уже существует");
        }
    }
}

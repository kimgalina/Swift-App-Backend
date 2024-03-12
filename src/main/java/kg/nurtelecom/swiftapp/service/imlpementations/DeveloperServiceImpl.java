package kg.nurtelecom.swiftapp.service.imlpementations;

import kg.nurtelecom.swiftapp.entity.Developer;
import kg.nurtelecom.swiftapp.exception.AlreadyExistException;
import kg.nurtelecom.swiftapp.mapper.DeveloperMapper;
import kg.nurtelecom.swiftapp.payload.DeveloperSignUpRequest;
import kg.nurtelecom.swiftapp.payload.DeveloperSignUpResponse;
import kg.nurtelecom.swiftapp.repository.DeveloperRepository;
import kg.nurtelecom.swiftapp.service.DeveloperService;
import kg.nurtelecom.swiftapp.service.ImageService;
import kg.nurtelecom.swiftapp.util.ResponseMessage;
import kg.nurtelecom.swiftapp.util.ResultCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeveloperServiceImpl implements DeveloperService {
    private final DeveloperRepository developerRepository;
    private final ImageService imageService;
    private final DeveloperMapper developerMapper;

    public DeveloperServiceImpl(DeveloperRepository developerRepository, ImageService imageService, DeveloperMapper developerMapper) {
        this.developerRepository = developerRepository;
        this.imageService = imageService;
        this.developerMapper = developerMapper;
    }

    @Transactional
    @Override
    public DeveloperSignUpResponse signUp(DeveloperSignUpRequest developerRequest) {
        if(developerRepository.findByEmail(developerRequest.email()).isPresent()) {
            throw new AlreadyExistException("Разработчик с таким email адресом уже существует");
        }
        Developer developerEntity = developerMapper.toEntity(developerRequest);
        developerRepository.save(developerEntity);
        return developerMapper.toResponse(developerEntity);

    }


}

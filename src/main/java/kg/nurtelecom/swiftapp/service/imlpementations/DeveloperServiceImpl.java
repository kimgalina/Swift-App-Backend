package kg.nurtelecom.swiftapp.service.imlpementations;

import kg.nurtelecom.swiftapp.entity.Developer;
import kg.nurtelecom.swiftapp.exception.AlreadyExistException;
import kg.nurtelecom.swiftapp.exception.NotFoundException;
import kg.nurtelecom.swiftapp.mapper.DeveloperMapper;
import kg.nurtelecom.swiftapp.payload.DeveloperResponse;
import kg.nurtelecom.swiftapp.payload.DeveloperSignUpRequest;
import kg.nurtelecom.swiftapp.payload.DeveloperSignUpResponse;
import kg.nurtelecom.swiftapp.payload.DeveloperUpdateRequest;
import kg.nurtelecom.swiftapp.repository.DeveloperRepository;
import kg.nurtelecom.swiftapp.service.DeveloperService;
import kg.nurtelecom.swiftapp.service.ImageService;
import kg.nurtelecom.swiftapp.util.ResponseMessage;
import kg.nurtelecom.swiftapp.util.ResultCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DeveloperServiceImpl implements DeveloperService {
    private final DeveloperRepository developerRepository;
    private final ImageService imageService;
    private final DeveloperMapper developerMapper;

    public DeveloperServiceImpl(DeveloperRepository developerRepository, ImageService imageService, DeveloperMapper developerMapper) {
        this.developerRepository = developerRepository;
        this.imageService = imageService;
        this.developerMapper = developerMapper;
    }


    @Override
    public DeveloperSignUpResponse signUp(DeveloperSignUpRequest developerRequest) {
        if(developerRepository.findByEmail(developerRequest.email()).isPresent()) {
            throw new AlreadyExistException("Разработчик с таким email адресом уже существует");
        }
        Developer developerEntity = developerMapper.toEntity(developerRequest);
        developerRepository.save(developerEntity);
        return developerMapper.toResponse(developerEntity);

    }

    @Override
    public DeveloperResponse getDeveloper(Long id) {
        Developer developer = developerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Разработчик с таким id не найден"));
        return developerMapper.toDeveloperResponse(developer);
    }

    @Override
    public DeveloperResponse updateDeveloper(Long id, DeveloperUpdateRequest developerRequest) {
        Developer developerEntity = developerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Разработчик с таким id не найден"));
        Developer developer = developerMapper.toEntityFromDeveloperUpdateRequest(developerRequest);
        developerEntity.setId(developer.getId());
        developerRepository.save(developerEntity);
        return developerMapper.toDeveloperResponse(developerEntity);
    }

    @Override
    public ResponseMessage<Void> deleteDeveloper(Long id) {
        if(developerRepository.findById(id).isEmpty()) {
            return new ResponseMessage<>(null, ResultCode.FAIL);
        }
        developerRepository.deleteById(id);
        return new ResponseMessage<>(null, ResultCode.SUCCESS);
    }
}

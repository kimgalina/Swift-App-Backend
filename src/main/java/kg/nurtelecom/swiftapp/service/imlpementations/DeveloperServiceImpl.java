package kg.nurtelecom.swiftapp.service.imlpementations;

import kg.nurtelecom.swiftapp.entity.Developer;
import kg.nurtelecom.swiftapp.mapper.DeveloperMapper;
import kg.nurtelecom.swiftapp.payload.DeveloperSignUpRequest;
import kg.nurtelecom.swiftapp.payload.DeveloperSignUpResponse;
import kg.nurtelecom.swiftapp.repository.DeveloperRepository;
import kg.nurtelecom.swiftapp.service.DeveloperService;
import kg.nurtelecom.swiftapp.util.ResponseMessage;
import kg.nurtelecom.swiftapp.util.ResultCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeveloperServiceImpl implements DeveloperService {
    private final DeveloperRepository developerRepository;
    private final DeveloperMapper developerMapper;

    public DeveloperServiceImpl(DeveloperRepository developerRepository, DeveloperMapper developerMapper) {
        this.developerRepository = developerRepository;
        this.developerMapper = developerMapper;
    }

    @Transactional
    @Override
    public ResponseMessage<DeveloperSignUpResponse> signUp(DeveloperSignUpRequest developerRequest) {
        Developer developerEntity = developerMapper.toEntity(developerRequest);
        developerRepository.save(developerEntity);
        return new ResponseMessage<>(developerMapper.toResponse(developerEntity), ResultCode.SUCCESS);

    }
}

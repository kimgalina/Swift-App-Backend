package kg.nurtelecom.swiftapp.mapper;

import kg.nurtelecom.swiftapp.entity.Developer;
import kg.nurtelecom.swiftapp.payload.DeveloperSignUpRequest;
import kg.nurtelecom.swiftapp.payload.DeveloperSignUpResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeveloperMapper {
    Developer toEntity(DeveloperSignUpRequest developerSignUpRequest);

    DeveloperSignUpResponse toResponse(Developer developer);
}

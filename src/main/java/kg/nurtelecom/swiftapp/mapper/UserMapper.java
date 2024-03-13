package kg.nurtelecom.swiftapp.mapper;

import kg.nurtelecom.swiftapp.entity.User;
import kg.nurtelecom.swiftapp.payload.UserCreateRequest;
import kg.nurtelecom.swiftapp.payload.UserResponse;
import kg.nurtelecom.swiftapp.payload.UserUpdateRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserCreateRequest userCreateRequest);
    UserResponse toResponse(User user);

    User toEntityFromUserUpdateRequest(UserUpdateRequest userRequest);
}

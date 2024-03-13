package kg.nurtelecom.swiftapp.service;

import kg.nurtelecom.swiftapp.entity.User;
import kg.nurtelecom.swiftapp.payload.UserCreateRequest;
import kg.nurtelecom.swiftapp.payload.UserResponse;
import kg.nurtelecom.swiftapp.payload.UserUpdateRequest;
import kg.nurtelecom.swiftapp.util.ResponseMessage;

public interface UserService {
    UserResponse findById(Long userId);
    ResponseMessage<UserResponse> createUser(UserCreateRequest userCreateRequest);
    ResponseMessage<UserResponse> updateUser(UserUpdateRequest userRequest, User user);
    ResponseMessage<Void> deleteUser(User user);
}

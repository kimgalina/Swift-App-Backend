package kg.nurtelecom.swiftapp.service.imlpementations;

import kg.nurtelecom.swiftapp.entity.User;
import kg.nurtelecom.swiftapp.exception.NotFoundException;
import kg.nurtelecom.swiftapp.exception.UserRegistrationException;
import kg.nurtelecom.swiftapp.mapper.UserMapper;
import kg.nurtelecom.swiftapp.payload.UserCreateRequest;
import kg.nurtelecom.swiftapp.payload.UserResponse;
import kg.nurtelecom.swiftapp.payload.UserUpdateRequest;
import kg.nurtelecom.swiftapp.repository.UserRepository;
import kg.nurtelecom.swiftapp.service.UserService;
import kg.nurtelecom.swiftapp.util.ResponseMessage;
import kg.nurtelecom.swiftapp.util.ResultCode;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserResponse findById(Long userId) {
        User userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Пользователь с таким id не найден"));
        return userMapper.toResponse(userEntity);
    }

    @Override
    public ResponseMessage<UserResponse> createUser(UserCreateRequest userCreateRequest) {
        if(!userCreateRequest.password().equals(userCreateRequest.confirmPassword())) {
            throw new UserRegistrationException("Ваши пароли не совпадают");
        }
        if(userRepository.findByNickname(userCreateRequest.nickname()).isPresent()) {
            throw new UserRegistrationException("Пользователь с таким nickname - ом уже существует");
        }

        User newUser = userMapper.toEntity(userCreateRequest);
        String encodedPassword = passwordEncoder.encode(newUser.getPassword());
        newUser.setPassword(encodedPassword);
        userRepository.save(newUser);
        return new ResponseMessage<>(
                userMapper.toResponse(newUser),
                ResultCode.SUCCESS
        );
    }

    @Override
    public ResponseMessage<UserResponse> updateUser(UserUpdateRequest userRequest, User user) {
        if(userRepository.findByNickname(userRequest.nickname()).isPresent()) {
            throw new UserRegistrationException("Пользователь с таким nickname - ом уже существует");
        }
        User updatedUser = userMapper.toEntityFromUserUpdateRequest(userRequest);
        updatedUser.setId(user.getId());
        updatedUser.setPassword(user.getPassword());
        userRepository.save(updatedUser);
        return new ResponseMessage<>(
                userMapper.toResponse(updatedUser),
                ResultCode.SUCCESS
        );

    }

    @Override
    public ResponseMessage<Void> deleteUser(User user) {
        userRepository.deleteById(user.getId());
        return new ResponseMessage<>(null, ResultCode.SUCCESS);
    }
}

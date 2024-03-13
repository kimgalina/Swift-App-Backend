package kg.nurtelecom.swiftapp.controller.api;

import jakarta.validation.Valid;
import kg.nurtelecom.swiftapp.entity.User;
import kg.nurtelecom.swiftapp.payload.UserCreateRequest;
import kg.nurtelecom.swiftapp.payload.UserResponse;
import kg.nurtelecom.swiftapp.payload.UserUpdateRequest;
import kg.nurtelecom.swiftapp.service.UserService;
import kg.nurtelecom.swiftapp.util.ResponseMessage;
import kg.nurtelecom.swiftapp.util.ResultCode;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseMessage<UserResponse> getUser(@PathVariable("id") Long userId) {
        return new ResponseMessage<>(
                userService.findById(userId),
                ResultCode.SUCCESS
        );
    }

    @PostMapping
    public ResponseMessage<UserResponse> create(@RequestBody @Valid UserCreateRequest userRequest) {
        return userService.createUser(userRequest);
    }

    @PutMapping
    public ResponseMessage<UserResponse> updateUser(@RequestBody @Valid UserUpdateRequest userRequest,
                                                    @AuthenticationPrincipal User user) {
        return userService.updateUser(userRequest, user);
    }

    @DeleteMapping
    public ResponseMessage<Void> deleteUser(@AuthenticationPrincipal User user) {
        return userService.deleteUser(user);
    }
}

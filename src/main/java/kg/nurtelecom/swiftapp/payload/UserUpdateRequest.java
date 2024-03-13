package kg.nurtelecom.swiftapp.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import kg.nurtelecom.swiftapp.entity.User;

public record UserUpdateRequest (
        @NotBlank(message = "Введите ваш username ")
        @Size(min = User.NICKNAME_MIN_LENGTH, max = User.NICKNAME_MAX_LENGTH, message = "Поле username должно быть от 3 до 50 символов")
        String nickname

){
}

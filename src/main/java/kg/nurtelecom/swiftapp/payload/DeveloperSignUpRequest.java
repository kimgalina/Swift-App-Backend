package kg.nurtelecom.swiftapp.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DeveloperSignUpRequest(
        @NotBlank(message = "Введите имя ")
        @Size(max = 50, message = "Имя '${validatedValue}' не может содержать большее чем {max} количество символов")
        String firstName,
        @NotBlank(message = "Введите фамилию ")
        @Size(max = 50, message = "Фамилия  '${validatedValue}' не может содержать большее чем {max} количество символов")
        String lastName,

        @NotBlank(message = "Введите должность ")
        @Size(max = 50, message = "Должность '${validatedValue}' не может содержать большее чем  {max} количество символов")
        String position,
        @NotBlank(message = "Введите номер телефона ")
        @Size(max = 20, message = "Номер телефона  '${validatedValue}' не может содержать большее чем  {max} количество символов ")
        String phone,
        @NotBlank(message = "Введите email ")
        @Email(message = "Введите реальный email адрес ")
        String email
) {
}

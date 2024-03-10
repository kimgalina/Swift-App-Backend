package kg.nurtelecom.swiftapp.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record DeveloperSignUpRequest(
        @JsonProperty("first_name")
        @NotBlank(message = "Введите имя ")
        @Size(max = 50, message = "Имя '${validatedValue}' не может содержать большее чем {max} количество символов")
        String firstName,
        @JsonProperty("last_name")
        @NotBlank(message = "Введите фамилию ")
        @Size(max = 50, message = "Фамилия  '${validatedValue}' не может содержать большее чем {max} количество символов")
        String lastName,

        @NotBlank(message = "Введите должность ")
        @Size(max = 50, message = "Должность '${validatedValue}' не может содержать большее чем  {max} количество символов")
        String position,
        @NotBlank(message = "Введите номер телефона ")
        @Size(max = 20, message = "Номер телефона  '${validatedValue}' не может содержать большее чем  {max} количество символов ")
        @Pattern(regexp = "^\\+?[0-9]*$", message = "Номер телефона должен начинаться либо с символа + и кода страны, либо содержать только цифры.")
        String phone,
        @NotBlank(message = "Введите email ")
        @Email(message = "Введите реальный email адрес ")
        String email
) {
}

package kg.nurtelecom.swiftapp.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

public class Developer {
    @Size(min = 2, max = 30, message = "Firstname should be between 2 and 30 characters")
    String firstname;
    @Size(min = 2, max = 30, message = "Lastname should be between 2 and 30 characters")
    String lastname;
    @Size(min = 2, max = 50, message = " between 2 and 50 characters")
    String position;
    @Size(max = 20, message = "Номер телефона  '${validatedValue}' не может содержать большее чем  {max} количество символов ")
    @Pattern(regexp = "^\\+?[0-9]*$", message = "Номер телефона должен начинаться либо с символа + и кода страны, либо содержать только цифры.")
    String phone;
    @Email
    String email;
    MultipartFile photo;

    public Developer(String firstname, String lastname, String position, String phone, String email, MultipartFile photo) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.position = position;
        this.phone = phone;
        this.email = email;
        this.photo = photo;
    }
    public Developer() {

    }
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public MultipartFile getPhoto() {
        return photo;
    }

    public void setPhoto(MultipartFile photo) {
        this.photo = photo;
    }
}

package kg.nurtelecom.swiftapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    public static final int NICKNAME_MIN_LENGTH = 3;
    public static final int NICKNAME_MAX_LENGTH = 50;
    public static final int PASSWORD_MIN_LENGTH = 20;
    public static final int PASSWORD_MAX_LENGTH = 150;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = NICKNAME_MAX_LENGTH, unique = true)
    private String nickname;

    @Column(length = PASSWORD_MAX_LENGTH)
    private String password;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package kg.nurtelecom.swiftapp.entity;

import jakarta.persistence.*;

@Entity
public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;


    private String lastName;


    private String avatar;


    private String position;


    private String phone;

    private String email;
}

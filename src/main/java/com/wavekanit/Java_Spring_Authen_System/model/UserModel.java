package com.wavekanit.Java_Spring_Authen_System.model;

import com.wavekanit.Java_Spring_Authen_System.dto.Auth.Register.UserRegisterRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String fName;
    private String lName;
    private String email;
    private String phone;
    private Integer access = 0;

    public UserModel(UserRegisterRequest payload) {
        this.username = payload.getUsername();
        this.password = payload.getPassword();
        this.fName = payload.getFName();
        this.lName = payload.getLName();
        this.email = payload.getEmail();
        this.phone = payload.getPhone();
    }
}

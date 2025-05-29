package com.wavekanit.Java_Spring_Authen_System.model;

import com.wavekanit.Java_Spring_Authen_System.dto.UserRegisterRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
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

    public UserModel() {}

    public UserModel(UserRegisterRequest payload) {
        this.username = payload.getUsername();
        this.password = payload.getPassword();
        this.fName = payload.getfName();
        this.lName = payload.getlName();
        this.email = payload.getEmail();
        this.phone = payload.getPhone();
    }

    public UserModel(String username, String password, String fName, String lName, String email, String phone) {
        this.username = username;
        this.password = password;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

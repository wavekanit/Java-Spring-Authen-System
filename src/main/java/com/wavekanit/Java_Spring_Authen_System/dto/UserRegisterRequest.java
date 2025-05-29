package com.wavekanit.Java_Spring_Authen_System.dto;

public class UserRegisterRequest {
    private String username;
    private String password;
    private String fName;
    private String lName;
    private String email;
    private String phone;

//    public UserRegisterRequest() {}

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}

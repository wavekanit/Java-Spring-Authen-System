package com.wavekanit.Java_Spring_Authen_System.dto;

public class UserRegisterResponse {
    private String username;
    private String status;

    public UserRegisterResponse(String username, String status) {
        this.username = username;
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public String getStatus() {
        return status;
    }
}

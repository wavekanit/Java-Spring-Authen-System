package com.wavekanit.Java_Spring_Authen_System.dto.Auth.Register;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterResponse {
    private String username;
    private String status;

    public UserRegisterResponse(String username, String status) {
        this.username = username;
        this.status = status;
    }
}

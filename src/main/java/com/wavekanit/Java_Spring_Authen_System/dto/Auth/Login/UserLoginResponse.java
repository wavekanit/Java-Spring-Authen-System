package com.wavekanit.Java_Spring_Authen_System.dto.Auth.Login;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserLoginResponse {
    private String username;
    private String message;
    private int statusCode;

    public UserLoginResponse(String username, String message, int statusCode) {
        this.username = username;
        this.message = message;
        this.statusCode = statusCode;
    }
}

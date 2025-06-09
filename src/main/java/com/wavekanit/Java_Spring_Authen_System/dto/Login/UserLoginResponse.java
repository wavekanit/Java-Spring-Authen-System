package com.wavekanit.Java_Spring_Authen_System.dto.Login;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserLoginResponse {
    private String username;
    private String message;

    public UserLoginResponse(String username, String message) {
        this.username = username;
        this.message = message;
    }
}

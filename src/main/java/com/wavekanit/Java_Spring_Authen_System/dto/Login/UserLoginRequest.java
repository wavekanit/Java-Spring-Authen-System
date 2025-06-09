package com.wavekanit.Java_Spring_Authen_System.dto.Login;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserLoginRequest {
    private String username;
    private String password;
}

package com.wavekanit.Java_Spring_Authen_System.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRegisterRequest {
    private String username;
    private String password;
    private String fName;
    private String lName;
    private String email;
    private String phone;
}

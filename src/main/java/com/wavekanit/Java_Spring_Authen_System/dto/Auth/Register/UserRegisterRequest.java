package com.wavekanit.Java_Spring_Authen_System.dto.Auth.Register;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRegisterRequest {
    private String username;
    private String password;
    @JsonProperty("fName")
    private String fName;
    @JsonProperty("lName")
    private String lName;
    private String email;
    private String phone;
}

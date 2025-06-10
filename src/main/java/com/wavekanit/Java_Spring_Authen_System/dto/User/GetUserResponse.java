package com.wavekanit.Java_Spring_Authen_System.dto.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetUserResponse {
    private Long id;
    private String username;
    private String fName;
    private String lName;
    private String email;
    private String phone;
    private Integer access;

    public GetUserResponse(
            Long id, String username, String fName, String lName, String email, String phone, Integer access
    ) {
        this.id = id;
        this.username = username;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.phone = phone;
        this.access = access;
    }
}

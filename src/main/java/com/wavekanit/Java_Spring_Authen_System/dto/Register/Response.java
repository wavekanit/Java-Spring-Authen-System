package com.wavekanit.Java_Spring_Authen_System.dto.Register;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response {
    private String username;
    private String status;

    public Response(String username, String status) {
        this.username = username;
        this.status = status;
    }
}

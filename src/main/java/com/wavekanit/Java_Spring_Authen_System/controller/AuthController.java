package com.wavekanit.Java_Spring_Authen_System.controller;

import com.wavekanit.Java_Spring_Authen_System.dto.Auth.Login.UserLoginRequest;
import com.wavekanit.Java_Spring_Authen_System.dto.Auth.Login.UserLoginResponse;
import com.wavekanit.Java_Spring_Authen_System.dto.Auth.Register.UserRegisterRequest;
import com.wavekanit.Java_Spring_Authen_System.dto.Auth.Register.UserRegisterResponse;
import com.wavekanit.Java_Spring_Authen_System.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class AuthController {
    private final AuthService userService;

    public AuthController(AuthService userService) {
        this.userService = userService;
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @PostMapping("/register")
    public UserRegisterResponse registerUser(@RequestBody UserRegisterRequest payload) {
        return userService.registerUser(payload);
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> loginUser(@RequestBody UserLoginRequest payload) {
        UserLoginResponse response = userService.loginUser(payload);

        if (response.getStatusCode() == 401) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        return ResponseEntity.ok(response);
    }
}

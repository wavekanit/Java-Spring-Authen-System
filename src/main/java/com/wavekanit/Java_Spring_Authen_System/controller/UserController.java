package com.wavekanit.Java_Spring_Authen_System.controller;

import com.wavekanit.Java_Spring_Authen_System.dto.Login.UserLoginRequest;
import com.wavekanit.Java_Spring_Authen_System.dto.Login.UserLoginResponse;
import com.wavekanit.Java_Spring_Authen_System.dto.Register.UserRegisterRequest;
import com.wavekanit.Java_Spring_Authen_System.dto.Register.UserRegisterResponse;
import com.wavekanit.Java_Spring_Authen_System.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
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
    public UserLoginResponse loginUser(@RequestBody UserLoginRequest payload) {
        return userService.loginUser(payload);
    }
}

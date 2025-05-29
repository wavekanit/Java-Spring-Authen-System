package com.wavekanit.Java_Spring_Authen_System.controller;

import com.wavekanit.Java_Spring_Authen_System.dto.UserRegisterRequest;
import com.wavekanit.Java_Spring_Authen_System.dto.UserRegisterResponse;
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
}

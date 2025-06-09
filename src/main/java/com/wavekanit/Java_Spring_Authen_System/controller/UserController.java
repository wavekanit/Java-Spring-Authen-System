package com.wavekanit.Java_Spring_Authen_System.controller;

import com.wavekanit.Java_Spring_Authen_System.dto.Register.Request;
import com.wavekanit.Java_Spring_Authen_System.dto.Register.Response;
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
    public Response registerUser(@RequestBody Request payload) {
        return userService.registerUser(payload);
    }
}

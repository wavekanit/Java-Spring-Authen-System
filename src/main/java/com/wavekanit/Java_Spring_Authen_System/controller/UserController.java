package com.wavekanit.Java_Spring_Authen_System.controller;

import com.wavekanit.Java_Spring_Authen_System.dto.User.GetUserByID.GetUserByIdResponse;
import com.wavekanit.Java_Spring_Authen_System.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    @PreAuthorize("principal.access >= 1")
    public GetUserByIdResponse getUserByID(@PathVariable Long id) {
        return userService.getUserByID(id);
    }
}

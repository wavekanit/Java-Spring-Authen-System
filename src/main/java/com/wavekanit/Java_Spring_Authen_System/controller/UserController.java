package com.wavekanit.Java_Spring_Authen_System.controller;

import com.wavekanit.Java_Spring_Authen_System.dto.User.GetUserResponse;
import com.wavekanit.Java_Spring_Authen_System.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/id/{id}")
    @PreAuthorize("principal.access >= 1")
    public GetUserResponse getUserByID(@PathVariable Long id) {
        return userService.getUserByID(id);
    }

    @GetMapping("/username/{username}")
    @PreAuthorize("principal.access >= 1")
    public GetUserResponse getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    @GetMapping("/all")
    @PreAuthorize("principal.access >= 1")
    public List<GetUserResponse> getAllUsers() {
        return userService.getAllUsers();
    }
}

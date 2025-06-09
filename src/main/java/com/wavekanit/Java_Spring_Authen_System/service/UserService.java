package com.wavekanit.Java_Spring_Authen_System.service;

import com.wavekanit.Java_Spring_Authen_System.dto.Register.Request;
import com.wavekanit.Java_Spring_Authen_System.dto.Register.Response;
import com.wavekanit.Java_Spring_Authen_System.model.UserModel;
import com.wavekanit.Java_Spring_Authen_System.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Response registerUser(Request payload) {
        UserModel userModel = new UserModel(payload);

        UserModel savedUser = userRepository.save(userModel);

        return new Response(
                savedUser.getUsername(),
                "success"
        );
    }
}

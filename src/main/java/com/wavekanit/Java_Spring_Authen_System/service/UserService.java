package com.wavekanit.Java_Spring_Authen_System.service;

import com.wavekanit.Java_Spring_Authen_System.dto.Register.UserRegisterRequest;
import com.wavekanit.Java_Spring_Authen_System.dto.Register.UserRegisterResponse;
import com.wavekanit.Java_Spring_Authen_System.model.UserModel;
import com.wavekanit.Java_Spring_Authen_System.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserRegisterResponse registerUser(UserRegisterRequest payload) {
        UserModel userModel = new UserModel(payload);

        UserModel savedUser = userRepository.save(userModel);

        return new UserRegisterResponse(
                savedUser.getUsername(),
                "success"
        );
    }
}

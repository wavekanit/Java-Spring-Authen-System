package com.wavekanit.Java_Spring_Authen_System.service;

import com.wavekanit.Java_Spring_Authen_System.dto.Login.UserLoginRequest;
import com.wavekanit.Java_Spring_Authen_System.dto.Login.UserLoginResponse;
import com.wavekanit.Java_Spring_Authen_System.dto.Register.UserRegisterRequest;
import com.wavekanit.Java_Spring_Authen_System.dto.Register.UserRegisterResponse;
import com.wavekanit.Java_Spring_Authen_System.model.UserModel;
import com.wavekanit.Java_Spring_Authen_System.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

    public UserLoginResponse loginUser(UserLoginRequest payload) {
        UserModel loginUser = userRepository.findByUsername(payload.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        if(!loginUser.getPassword().equals(payload.getPassword())) {
            return new UserLoginResponse(
                    payload.getUsername(),
                    "login failed",
                    401
            );
        }

        return new UserLoginResponse(
                payload.getUsername(),
                "login successfully",
                200
        );
    }
}

package com.wavekanit.Java_Spring_Authen_System.service;

import com.wavekanit.Java_Spring_Authen_System.dto.Auth.Login.UserLoginRequest;
import com.wavekanit.Java_Spring_Authen_System.dto.Auth.Login.UserLoginResponse;
import com.wavekanit.Java_Spring_Authen_System.dto.Auth.Register.UserRegisterRequest;
import com.wavekanit.Java_Spring_Authen_System.dto.Auth.Register.UserRegisterResponse;
import com.wavekanit.Java_Spring_Authen_System.model.UserModel;
import com.wavekanit.Java_Spring_Authen_System.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.wavekanit.Java_Spring_Authen_System.security.JwtToken;

import java.util.Optional;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtToken jwtToken;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtToken jwtToken) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtToken = jwtToken;
    }

    public UserRegisterResponse registerUser(UserRegisterRequest payload) {
        Optional<UserModel> existsUser = userRepository.findByUsername(payload.getUsername());
        if (existsUser.isPresent()) {
            return new UserRegisterResponse(
                    payload.getUsername(),
                    "username already exists"
            );
        }
        UserModel userModel = new UserModel(payload);

        String hashedPassword = passwordEncoder.encode(userModel.getPassword());
        userModel.setPassword(hashedPassword);

        UserModel savedUser = userRepository.save(userModel);

        return new UserRegisterResponse(
                savedUser.getUsername(),
                "success"
        );
    }

    public UserLoginResponse loginUser(UserLoginRequest payload) {
        UserModel loginUser = userRepository.findByUsername(payload.getUsername()).orElse(null);
        if (loginUser == null || !passwordEncoder.matches(payload.getPassword(), loginUser.getPassword())) {
            return new UserLoginResponse(
                    payload.getUsername(),
                    "login failed",
                    401,
                    null
            );
        }

        String token = jwtToken.generateToken(loginUser);

        return new UserLoginResponse(
                payload.getUsername(),
                "login successfully",
                200,
                token
        );
    }
}

package com.wavekanit.Java_Spring_Authen_System.service;

import com.wavekanit.Java_Spring_Authen_System.dto.User.GetUserByID.GetUserByIdResponse;
import com.wavekanit.Java_Spring_Authen_System.model.UserModel;
import com.wavekanit.Java_Spring_Authen_System.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public GetUserByIdResponse getUserByID(Long id) {
        UserModel user = userRepository.findById(id).orElse(null);

        if (user == null) {
            return null;
        }

        return new GetUserByIdResponse(
                user.getId(),
                user.getUsername(),
                user.getFName(),
                user.getLName(),
                user.getEmail(),
                user.getPhone(),
                user.getAccess()
        );
    }
}

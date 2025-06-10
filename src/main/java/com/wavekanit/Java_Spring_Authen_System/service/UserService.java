package com.wavekanit.Java_Spring_Authen_System.service;

import com.wavekanit.Java_Spring_Authen_System.dto.User.GetUserResponse;
import com.wavekanit.Java_Spring_Authen_System.model.UserModel;
import com.wavekanit.Java_Spring_Authen_System.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public GetUserResponse getUserByID(Long id) {
        UserModel user = userRepository.findById(id).orElse(null);

        if (user == null) {
            return null;
        }

        return new GetUserResponse(
                user.getId(),
                user.getUsername(),
                user.getFName(),
                user.getLName(),
                user.getEmail(),
                user.getPhone(),
                user.getAccess()
        );
    }

    public GetUserResponse getUserByUsername(String username) {
        UserModel user = userRepository.findByUsername(username).orElse(null);

        if (user == null) {
            return null;
        }

        return new GetUserResponse(
                user.getId(),
                user.getUsername(),
                user.getFName(),
                user.getLName(),
                user.getEmail(),
                user.getPhone(),
                user.getAccess()
        );
    }

    public List<GetUserResponse> getAllUsers() {
        List<UserModel> users = userRepository.findAll();

        return users.stream()
                .map(user -> new GetUserResponse(
                        user.getId(),
                        user.getUsername(),
                        user.getFName(),
                        user.getLName(),
                        user.getEmail(),
                        user.getPhone(),
                        user.getAccess()
                ))
                .collect(Collectors.toList());
    }
}

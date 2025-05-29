package com.wavekanit.Java_Spring_Authen_System.repository;

import com.wavekanit.Java_Spring_Authen_System.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {}

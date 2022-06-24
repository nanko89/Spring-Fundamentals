package com.example.battleships.service;

import com.example.battleships.model.entity.User;
import com.example.battleships.model.service.UserServiceModel;

import java.util.Optional;

public interface UserService {
    boolean isFreeUsername(String username);

    boolean isFreeEmail(String email);

    UserServiceModel login(UserServiceModel userServiceModel);

    void registerUser(UserServiceModel userServiceModel);

    User findByUsername(String username);
}

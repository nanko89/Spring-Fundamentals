package com.example.battleships.service;

import com.example.battleships.model.service.UserServiceModel;

public interface UserService {
    boolean isFreeUsername(String username);

    boolean isFreeEmail(String email);

    UserServiceModel login(UserServiceModel userServiceModel);

    void registerUser(UserServiceModel userServiceModel);
}

package com.example.gira.service;

import com.example.gira.model.service.UserServiceModel;

public interface UserService {
    boolean isFreeUsername(String username);

    boolean isFreeEmail(String email);

    UserServiceModel findByEmail(String email);

    void registerUser(UserServiceModel serviceModel);

    UserServiceModel login(UserServiceModel loginUser);
}

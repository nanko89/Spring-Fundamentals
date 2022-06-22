package com.example.andrey.service;

import com.example.andrey.model.service.UserServiceModel;

public interface UserService {
    boolean isFreeUsername(String username);

    boolean isFreeEmail(String email);

    UserServiceModel login(UserServiceModel userServiceModel);

    void registerUser(UserServiceModel userServiceModel);
}

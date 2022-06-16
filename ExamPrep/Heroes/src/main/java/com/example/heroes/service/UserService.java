package com.example.heroes.service;

import com.example.heroes.model.service.UserServiceModel;

public interface UserService {
    boolean isFreeUsername(String username);

    boolean isFreeEmail(String email);

    UserServiceModel login(UserServiceModel userServiceModel);
}

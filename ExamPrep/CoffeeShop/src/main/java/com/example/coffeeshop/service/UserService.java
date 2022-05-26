package com.example.coffeeshop.service;

import com.example.coffeeshop.model.service.UserServiceModel;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loggedIn(Long id, String username);
}

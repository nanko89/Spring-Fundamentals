package com.example.shopinglistexam.service;

import com.example.shopinglistexam.model.service.UserServiceModel;

public interface UserService {
    boolean register(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);
}

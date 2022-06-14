package com.example.mymusicdb.service;

import com.example.mymusicdb.model.entity.User;
import com.example.mymusicdb.model.service.UserServiceModel;

public interface UserService {
    boolean isFreeUsername(String username);

    boolean isFreeEmail(String email);

    UserServiceModel login(UserServiceModel userServiceModel);

    void registerUser(UserServiceModel userServiceModel);

    User findByUsername(String username);
}

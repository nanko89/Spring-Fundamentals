package com.example.andrey.service;

import com.example.andrey.model.service.UserServiceModel;

public interface UserService {

    UserServiceModel loginUser(String username, String password);

    boolean existByUsername(String username);

    void saveUser(UserServiceModel userServiceModel);
}

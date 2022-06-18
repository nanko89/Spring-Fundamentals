package com.example.shoppinglist.service;

import com.example.shoppinglist.model.service.UserServiceModel;

public interface UserService {
    boolean isFreeEmail(String email);

    boolean isFreeUsername(String username);

    UserServiceModel login(UserServiceModel serviceModel);

    void register(UserServiceModel serviceModel);
}

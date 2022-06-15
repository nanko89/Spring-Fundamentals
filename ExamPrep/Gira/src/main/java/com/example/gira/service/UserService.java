package com.example.gira.service;

import com.example.gira.model.service.UserServiceModel;

public interface UserService {
    boolean isFreeUsername(String username);

    boolean isFreeEmail(String email);

    boolean existByEmailAndPassword(String email, String password);

    UserServiceModel findByEmail(String email);
}

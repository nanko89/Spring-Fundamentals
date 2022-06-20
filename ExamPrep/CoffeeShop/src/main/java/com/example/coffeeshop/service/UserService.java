package com.example.coffeeshop.service;

import com.example.coffeeshop.model.entity.User;
import com.example.coffeeshop.model.service.UserServiceModel;
import com.example.coffeeshop.model.view.UserViewModel;

import java.util.List;

public interface UserService {
    boolean isFreeUsername(String username);

    boolean isFreeEmail(String email);

    UserServiceModel registerUser(UserServiceModel userServiceModel);

    UserServiceModel loginUser(UserServiceModel userServiceModel);

    User findByUsername(String username);

    List<UserViewModel> getAllEmployees();
}

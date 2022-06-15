package com.example.springmobilele.service;

import com.example.springmobilele.models.entity.User;
import com.example.springmobilele.models.service.UserLoginServiceModel;
import com.example.springmobilele.models.service.UserRegistrationServiceModel;

public interface UserService {

    void initializeUserAndRole();

    boolean login(UserLoginServiceModel userLoginServiceModel);

    void logout();

    void registerUser(UserRegistrationServiceModel userRegister);

    boolean isFreeUsername(String username);

    User findByUsername(String username);
}

package com.example.springmobilele.service;

import com.example.springmobilele.models.service.UserLoginServiceModel;
import com.example.springmobilele.models.service.UserRegistrationServiceModel;

public interface UserService {

    void initializeUserAndRole();

    boolean login(UserLoginServiceModel userLoginServiceModel);

    boolean logout();

    void registerUser(UserRegistrationServiceModel userRegister);
}

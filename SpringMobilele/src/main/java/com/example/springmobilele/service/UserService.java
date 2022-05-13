package com.example.springmobilele.service;

import com.example.springmobilele.models.service.UserLoginServiceModel;

public interface UserService {

    void initializeUserAndRole();

    boolean login(UserLoginServiceModel userLoginServiceModel);

    boolean logout();
}

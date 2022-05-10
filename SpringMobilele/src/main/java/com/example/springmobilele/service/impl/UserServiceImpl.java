package com.example.springmobilele.service.impl;

import com.example.springmobilele.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public boolean login(String username, String password) {
        return false;
    }
}

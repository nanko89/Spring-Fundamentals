package com.example.springmobilele.service.impl;

import com.example.springmobilele.models.entity.User;
import com.example.springmobilele.models.service.UserLoginServiceModel;
import com.example.springmobilele.repository.UserRepository;
import com.example.springmobilele.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public boolean login(UserLoginServiceModel userLoginServiceModel) {

        Optional<User> userOptional = userRepository
                .findByUsername(userLoginServiceModel
                        .getUsername());

        if (userOptional.isEmpty()) {
            return false;
        } else {
            return passwordEncoder
                    .matches(userLoginServiceModel.getPassword(), userOptional.get().getPassword());
        }
    }
}

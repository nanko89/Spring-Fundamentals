package com.example.gira.service.impl;

import com.example.gira.model.entity.User;
import com.example.gira.model.service.UserServiceModel;
import com.example.gira.repository.UserRepository;
import com.example.gira.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean isFreeUsername(String username) {
        return userRepository
                .findByUsernameIgnoreCase(username)
                .isEmpty();
    }

    @Override
    public boolean isFreeEmail(String email) {
        return userRepository
                .findByEmailIgnoreCase(email)
                .isEmpty();
    }

    @Override
    public boolean existByEmailAndPassword(String email, String password) {
        return userRepository
                .existsByEmailAndPassword(email, password);
    }

    @Override
    public UserServiceModel findByEmail(String email) {
        User user = userRepository
                .findByEmailIgnoreCase(email)
                .orElse(null);
        return modelMapper
                .map(user, UserServiceModel.class);
    }
}

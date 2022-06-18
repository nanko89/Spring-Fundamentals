package com.example.shoppinglist.service.impl;

import com.example.shoppinglist.model.entity.User;
import com.example.shoppinglist.model.service.UserServiceModel;
import com.example.shoppinglist.repository.UserRepository;
import com.example.shoppinglist.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean isFreeEmail(String email) {
        return this.userRepository
                .findByEmailIgnoreCase(email)
                .isEmpty();
    }

    @Override
    public boolean isFreeUsername(String username) {
        return this.userRepository
                .findByUsernameIgnoreCase(username)
                .isEmpty();
    }

    @Override
    public UserServiceModel login(UserServiceModel serviceModel) {

        User user = userRepository
                .findByUsernameIgnoreCase(serviceModel.getUsername())
                .orElse(null);

        if (user == null) {
            return null;
        }

        boolean matches = passwordEncoder
                .matches (serviceModel.getPassword(), user.getPassword());

        if (!matches) {
            return null;
        }

        return modelMapper.map(user, UserServiceModel.class);
    }

    @Override
    public void register(UserServiceModel serviceModel) {
        User user = modelMapper.map(serviceModel, User.class);
        user
                .setPassword(passwordEncoder.encode(serviceModel.getPassword()));

        userRepository.save(user);
    }
}

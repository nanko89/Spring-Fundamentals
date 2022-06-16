package com.example.gira.service.impl;

import com.example.gira.model.entity.User;
import com.example.gira.model.service.UserServiceModel;
import com.example.gira.repository.UserRepository;
import com.example.gira.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public UserServiceModel findByEmail(String email) {
        User user = userRepository
                .findByEmailIgnoreCase(email)
                .orElse(null);
        return modelMapper
                .map(user, UserServiceModel.class);
    }

    @Override
    public void registerUser(UserServiceModel serviceModel) {
        User user = modelMapper
                .map(serviceModel, User.class);

        user.setPassword(passwordEncoder.encode(serviceModel.getPassword()));

        userRepository.save(user);
    }

    @Override
    public UserServiceModel login(UserServiceModel loginUser) {

        Optional<User> user = userRepository
                .findByEmailIgnoreCase(loginUser.getEmail());

        if (user.isEmpty()){
            return null;
        }

        boolean success = passwordEncoder
                .matches(loginUser.getPassword(), user.get().getPassword());

        if (!success){
            return null;
        }

        return modelMapper.map(user, UserServiceModel.class);
    }


}

package com.example.heroes.service.impl;

import com.example.heroes.model.entity.User;
import com.example.heroes.model.service.UserServiceModel;
import com.example.heroes.repository.UserRepository;
import com.example.heroes.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean isFreeUsername(String username) {
        return this.userRepository
                .findByUsernameIgnoreCase(username)
                .isEmpty();
    }

    @Override
    public boolean isFreeEmail(String email) {
        return this.userRepository
                .findByEmailIgnoreCase(email)
                .isEmpty();
    }

    @Override
    public UserServiceModel login(UserServiceModel userServiceModel) {

        Optional<User> user = userRepository
                .findByUsernameIgnoreCase(userServiceModel.getUsername());

        if (user.isEmpty()){
            return null;
        }

        boolean success = passwordEncoder
                .matches(userServiceModel.getPassword(), user.get().getPassword());

        if (!success){
            return null;
        }

        return modelMapper.map(user, UserServiceModel.class);
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        User user = modelMapper
                .map(userServiceModel, User.class);

        user.setPassword(passwordEncoder.encode(userServiceModel.getPassword()));

        userRepository.save(user);
    }
}

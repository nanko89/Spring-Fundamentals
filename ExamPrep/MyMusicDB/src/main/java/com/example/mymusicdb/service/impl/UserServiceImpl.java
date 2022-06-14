package com.example.mymusicdb.service.impl;

import com.example.mymusicdb.model.entity.User;
import com.example.mymusicdb.model.service.UserServiceModel;
import com.example.mymusicdb.repository.UserRepository;
import com.example.mymusicdb.service.UserService;
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
    public UserServiceModel login(UserServiceModel userServiceModel) {

        Optional<User> user = userRepository
                .findByUsernameIgnoreCase(userServiceModel.getUsername());

        if (user.isEmpty()) {
            return null;
        }

        boolean success = passwordEncoder.matches(userServiceModel.getPassword(),user.get().getPassword());

        if (!success) {
            return null;
        }

        return modelMapper.map(user, UserServiceModel.class);
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        User user = modelMapper
                .map(userServiceModel, User.class);

        user.setPassword(passwordEncoder
                .encode(userServiceModel.getPassword()));

        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository
                .findByUsernameIgnoreCase(username)
                .orElse(null);
    }
}

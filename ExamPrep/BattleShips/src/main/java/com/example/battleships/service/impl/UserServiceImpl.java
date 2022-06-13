package com.example.battleships.service.impl;


import com.example.battleships.model.entity.User;
import com.example.battleships.model.service.UserServiceModel;
import com.example.battleships.repository.UserRepository;
import com.example.battleships.service.UserService;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpSession;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    private final HttpSession httpSession;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper,
                           PasswordEncoder passwordEncoder, HttpSession httpSession) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.httpSession = httpSession;

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
    public boolean loginUser(UserServiceModel userServiceModel) {

        Optional<User> optionalUser = userRepository
                .findByUsername(userServiceModel.getUsername());

        if (optionalUser.isEmpty()) {
            logout();
            return false;
        }

        boolean success = passwordEncoder
                .matches(userServiceModel.getPassword(), optionalUser.get().getPassword());

        if (success) {
            User userLogged = optionalUser.get();

        }

        return success;
    }

    @Override
    public void logout() {
        httpSession.invalidate();
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
    public User findById() {
        return null;
    }

    @Override
    public UserServiceModel findByUsername(String username) {
        return modelMapper
                .map(userRepository.findByUsername(username)
                        .orElse(null), UserServiceModel.class);
    }

}

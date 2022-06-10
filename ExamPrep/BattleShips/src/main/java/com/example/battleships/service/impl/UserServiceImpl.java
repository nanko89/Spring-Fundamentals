package com.example.battleships.service.impl;

import com.example.battleships.model.binding.UserLoginBindingModel;
import com.example.battleships.model.entity.User;
import com.example.battleships.model.service.UserServiceModel;
import com.example.battleships.repository.UserRepository;
import com.example.battleships.service.UserService;
import com.example.battleships.user.CurrentUser;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.currentUser = currentUser;
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        User user = modelMapper
                .map(userServiceModel, User.class);

        user.setPassword(passwordEncoder
                .encode(userServiceModel.getPassword()));

        userRepository.save(user);

        login(user);
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

            login(userLogged);
        }

        return success;
    }

    @Override
    public void logout() {
        currentUser.clean();
    }

    private void login(User user) {
        currentUser.setLoggedIn(true);
        currentUser.setFullName(user.getFullName());
        currentUser.setUsername(user.getUsername());
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
}

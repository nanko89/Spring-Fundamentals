package com.example.pathfinder.service.impl;

import com.example.pathfinder.model.entity.Role;
import com.example.pathfinder.model.entity.User;
import com.example.pathfinder.model.entity.enums.Level;
import com.example.pathfinder.model.service.UserServiceModel;
import com.example.pathfinder.repository.UserRepository;
import com.example.pathfinder.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {

        User user = modelMapper.map(userServiceModel, User.class);
        user.setLevel(Level.BEGINNER);

        userRepository.save(user);
    }
}

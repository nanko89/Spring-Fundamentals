package com.example.andrey.service.impl;

import com.example.andrey.model.entity.User;
import com.example.andrey.model.service.UserServiceModel;
import com.example.andrey.repository.UserRepository;
import com.example.andrey.service.UserService;
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
    public UserServiceModel loginUser(String username, String password) {
        return modelMapper
                .map(userRepository.findByUsernameAndPassword(username, password),
                        UserServiceModel.class);
    }

    @Override
    public boolean existByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public void saveUser(UserServiceModel userServiceModel) {
         userRepository
                .save(modelMapper.map(userServiceModel, User.class));
    }
}

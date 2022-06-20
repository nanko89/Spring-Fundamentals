package com.example.coffeeshop.service.impl;


import com.example.coffeeshop.model.entity.User;
import com.example.coffeeshop.model.service.UserServiceModel;
import com.example.coffeeshop.model.view.UserViewModel;
import com.example.coffeeshop.repository.UserRepository;
import com.example.coffeeshop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public UserServiceModel registerUser(UserServiceModel userServiceModel) {
        User user = modelMapper.map(userServiceModel, User.class);
        user.setPassword(passwordEncoder.encode(userServiceModel.getPassword()));

        userRepository.save(user);
        return modelMapper.map(user, UserServiceModel.class);
    }

    @Override
    public UserServiceModel loginUser(UserServiceModel userServiceModel) {
        Optional<User> user = userRepository
                .findByUsernameIgnoreCase(userServiceModel.getUsername());

        if (user.isEmpty()) {
            return null;
        }

        boolean matches = passwordEncoder
                .matches(userServiceModel.getPassword(), user.get().getPassword());

        if (!matches) {
            return null;
        }

        return modelMapper.map(user, UserServiceModel.class);
    }

    @Override
    public User findByUsername(String username) {
        return this.userRepository
                .findByUsernameIgnoreCase(username)
                .orElse(null);
    }

    @Override
    public List<UserViewModel> getAllEmployees() {

        return userRepository.findAll()
                .stream()
                .sorted(Comparator.comparingInt(u -> u.getOrders().size()))
                .map(user -> new UserViewModel()
                        .setUsername(user.getUsername())
                        .setOrdersCount(user.getOrders().size()))
                .collect(Collectors.toList());
    }
}

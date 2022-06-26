package com.example.finalexam.service.impl;

import com.example.finalexam.model.entity.Song;
import com.example.finalexam.model.entity.User;
import com.example.finalexam.model.service.UserServiceModel;
import com.example.finalexam.model.view.SongViewModel;
import com.example.finalexam.repository.UserRepository;
import com.example.finalexam.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
    public UserServiceModel login(UserServiceModel userServiceModel) {
        Optional<User> user = this.userRepository
                .findByUsernameIgnoreCase(userServiceModel.getUsername());

        if (user.isEmpty()){
            return null;
        }

        boolean matches = passwordEncoder
                .matches
                        (userServiceModel.getPassword(), user.get().getPassword());

        if( !matches){
            return null;
        }


        return modelMapper
                .map(user.get(), UserServiceModel.class);
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {

        User user = modelMapper
                .map(userServiceModel, User.class);

        user
                .setPassword(passwordEncoder
                        .encode(userServiceModel.getPassword()));

        this.userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return this.userRepository
                .findByUsernameIgnoreCase(username)
                .orElse(null);
    }

    @Override
    public void addSong(Song song, UserServiceModel serviceModel) {

        Optional<User> user = this.userRepository
                .findByUsernameIgnoreCase(serviceModel.getUsername());

        user.get().getPlaylist().add(song);

        userRepository.save(user.get());
    }

    @Override
    public List<SongViewModel> getPlaylist(UserServiceModel userServiceModel) {
        User user = this.userRepository
                .findByUsernameIgnoreCase(userServiceModel.getUsername()).orElse(null);

        return user.getPlaylist()
                .stream()
                .map(song -> modelMapper.map(song, SongViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public Double getTotalTime(UserServiceModel userServiceModel) {
        User user = this.userRepository
                .findByUsernameIgnoreCase(userServiceModel.getUsername()).orElse(null);

        int sum = user.getPlaylist().stream().mapToInt(Song::getDuration).sum();

        return (double) (sum / 60);
    }

    @Override
    public void removeSongs(Long id) {
        Optional<User> user = this.userRepository.findById(id);
        user.get().getPlaylist().clear();
        userRepository.save(user.get());
    }
}

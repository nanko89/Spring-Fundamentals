package com.example.spotifyplaylistapp.service.impl;

import com.example.spotifyplaylistapp.model.dto.UserLoginDTO;
import com.example.spotifyplaylistapp.model.dto.UserRegisterDTO;
import com.example.spotifyplaylistapp.model.entity.Song;
import com.example.spotifyplaylistapp.model.entity.User;
import com.example.spotifyplaylistapp.repository.UserRepository;
import com.example.spotifyplaylistapp.service.UserService;
import com.example.spotifyplaylistapp.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final CurrentUser currentUser;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, CurrentUser currentUser, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean isFreeEmail(String email) {
        return this.userRepository
                .findByEmailIgnoreCase(email)
                .isEmpty();
    }

    @Override
    public boolean isFreeUsername(String username) {
        return userRepository.findByUsernameIgnoreCase(username)
                .isEmpty();
    }

    @Override
    public UserLoginDTO login(UserLoginDTO loginDTO) {
        Optional<User> user = this.userRepository
                .findByUsernameIgnoreCase(loginDTO.getUsername());

        if (user.isEmpty()){
            return null;
        }

        boolean matches = user.get().getPassword().equals(loginDTO.getPassword());

        if( !matches){
            return null;
        }


        return modelMapper.map(user, UserLoginDTO.class);
    }

    @Override
    public void registerUser(UserRegisterDTO userRegisterDTO) {
        User user = modelMapper
                .map(userRegisterDTO, User.class);

        user.setPlaylist(new HashSet<>());

        this.userRepository.save(user);
    }


    @Override
    public void addSongToPlaylist(Song song) {
        User user = userRepository
                .findById(currentUser.getId()).orElse(null);

        user.getPlaylist().add(song);

        userRepository.save(user);
    }

    @Override
    public String findTotalTimeToPlaylist() {

        User user = userRepository.findById(currentUser.getId()).orElse(null);

        int sum = user.getPlaylist()
                .stream()
                .mapToInt(Song::getDuration)
                .sum();


        long minutes = sum / 60;
        long seconds = sum % 60;
        return String.format("%02d:%02d", minutes, seconds);

    }

    @Override
    public User findByName() {
        return userRepository
                .findByUsernameIgnoreCase(currentUser.getUsername())
                .orElse(null);
    }

    @Override
    public void clearPlaylist() {
        User user = userRepository.findById(currentUser.getId()).orElse(null);

        user.getPlaylist().clear();

        userRepository.save(user);
    }
}

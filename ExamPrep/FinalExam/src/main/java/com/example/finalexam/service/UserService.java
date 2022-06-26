package com.example.finalexam.service;

import com.example.finalexam.model.entity.Song;
import com.example.finalexam.model.entity.User;
import com.example.finalexam.model.service.UserServiceModel;
import com.example.finalexam.model.view.SongViewModel;

import java.util.List;

public interface UserService {
    boolean isFreeUsername(String username);

    boolean isFreeEmail(String email);

    UserServiceModel login(UserServiceModel userServiceModel);

    void registerUser(UserServiceModel userServiceModel);

    User findByUsername(String username);

    void addSong(Song song, UserServiceModel serviceModel);

    List<SongViewModel> getPlaylist(UserServiceModel user);

    Double getTotalTime(UserServiceModel user);

    void removeSongs(Long id);

}

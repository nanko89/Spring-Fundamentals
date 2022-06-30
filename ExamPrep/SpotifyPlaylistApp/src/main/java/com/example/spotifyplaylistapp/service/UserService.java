package com.example.spotifyplaylistapp.service;

import com.example.spotifyplaylistapp.model.dto.UserLoginDTO;
import com.example.spotifyplaylistapp.model.dto.UserRegisterDTO;
import com.example.spotifyplaylistapp.model.dto.ViewSongDTO;
import com.example.spotifyplaylistapp.model.entity.Song;
import com.example.spotifyplaylistapp.model.entity.User;

public interface UserService {
    boolean isFreeEmail(String email);

    boolean isFreeUsername(String username);

    UserLoginDTO login(UserLoginDTO loginDTO);

    void registerUser(UserRegisterDTO userRegisterDTO);


    void addSongToPlaylist(Song song);

    String findTotalTimeToPlaylist();

    User findByName();

    void clearPlaylist();

}

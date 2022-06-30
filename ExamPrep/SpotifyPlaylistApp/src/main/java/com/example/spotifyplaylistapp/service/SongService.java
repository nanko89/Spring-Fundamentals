package com.example.spotifyplaylistapp.service;

import com.example.spotifyplaylistapp.model.dto.SongAddDTO;
import com.example.spotifyplaylistapp.model.dto.ViewSongDTO;
import com.example.spotifyplaylistapp.model.entity.Song;
import com.example.spotifyplaylistapp.model.entity.enums.StyleName;

import java.util.List;
import java.util.Optional;

public interface SongService {

    boolean isFreeName(String performer);


    void addSong(SongAddDTO songAddDTO);

    List<ViewSongDTO> findBySongStyle(StyleName pop);

    List<ViewSongDTO> getPlaylist();

    Song findById(Long id);
}

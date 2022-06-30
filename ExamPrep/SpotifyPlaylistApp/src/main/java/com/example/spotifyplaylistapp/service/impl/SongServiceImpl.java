package com.example.spotifyplaylistapp.service.impl;

import com.example.spotifyplaylistapp.model.dto.SongAddDTO;
import com.example.spotifyplaylistapp.model.dto.ViewSongDTO;
import com.example.spotifyplaylistapp.model.entity.Song;

import com.example.spotifyplaylistapp.model.entity.Style;
import com.example.spotifyplaylistapp.model.entity.User;
import com.example.spotifyplaylistapp.model.entity.enums.StyleName;
import com.example.spotifyplaylistapp.repository.SongRepository;
import com.example.spotifyplaylistapp.service.SongService;
import com.example.spotifyplaylistapp.service.StyleService;
import com.example.spotifyplaylistapp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SongServiceImpl implements SongService {
    private final SongRepository songRepository;
    private final UserService userService;

    private final StyleService styleService;
    private final ModelMapper modelMapper;

    public SongServiceImpl(SongRepository songRepository, UserService userService, StyleService styleService, ModelMapper modelMapper) {
        this.songRepository = songRepository;
        this.userService = userService;
        this.styleService = styleService;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean isFreeName(String performer) {
        return songRepository
                .findByPerformerIgnoreCase(performer)
                .isEmpty();
    }

    @Override
    public void addSong(SongAddDTO songAddDTO) {

        Song song = modelMapper.map(songAddDTO, Song.class);

        Style style = styleService.findByStyleName(songAddDTO.getStyle());

        song.setStyle(style);

        songRepository.save(song);

        userService.addSongToPlaylist(song);

    }

    @Override
    public List<ViewSongDTO> findBySongStyle(StyleName style) {

        return  songRepository.findAll()
                .stream()
                .filter(song -> song.getStyle().getName().equals(style))
                .map(this::mapSongs)
                .collect(Collectors.toList());
    }

    @Override
    public List<ViewSongDTO> getPlaylist() {
        User user = userService.findByName();

        return user.getPlaylist()
                .stream()
                .map(this::mapSongs)
                .collect(Collectors.toList());

    }

    @Override
    public Song findById(Long id) {
        return songRepository.findById(id).orElse(null);
    }

    private ViewSongDTO mapSongs(Song song) {

        Integer songDuration = song.getDuration();
        ViewSongDTO viewSongDTO = new ViewSongDTO();

        long minutes = songDuration / 60;
        long seconds = songDuration % 60;
        String duration = String.format("%02d:%02d", minutes, seconds);


        viewSongDTO.setDuration(duration)
                .setPerformer(song.getPerformer())
                .setId(song.getId())
                .setTitle(song.getTitle());

        return viewSongDTO;
    }


}

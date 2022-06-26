package com.example.finalexam.service.impl;

import com.example.finalexam.model.entity.Song;
import com.example.finalexam.model.entity.Style;
import com.example.finalexam.model.entity.enums.StyleName;
import com.example.finalexam.model.service.SongServiceModel;
import com.example.finalexam.model.service.UserServiceModel;
import com.example.finalexam.model.view.SongViewModel;
import com.example.finalexam.repository.SongRepository;
import com.example.finalexam.service.SongService;
import com.example.finalexam.service.StyleService;
import com.example.finalexam.service.UserService;
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
        return this.songRepository
                .findByPerformerIgnoreCase(performer)
                .isEmpty();
    }

    @Override
    public void addSong(SongServiceModel songServiceModel, UserServiceModel serviceModel) {

        Style style = this.styleService
                .findByStyleName(songServiceModel.getStyle());

        Song song = modelMapper
                .map(songServiceModel, Song.class);

        song.setStyle(style);

        this.songRepository.save(song);

        userService.addSong(song, serviceModel);
    }

    @Override
    public List<SongViewModel> findByStyleName(StyleName styleName) {
        return this.songRepository.findByStyle_Name(styleName)
                .stream()
                .map(song -> modelMapper.map(song, SongViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public Song findById(Long id) {
        return this.songRepository.findById(id).orElse(null);
    }


}

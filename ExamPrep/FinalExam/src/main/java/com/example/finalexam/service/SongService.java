package com.example.finalexam.service;

import com.example.finalexam.model.entity.Song;
import com.example.finalexam.model.entity.enums.StyleName;
import com.example.finalexam.model.service.SongServiceModel;
import com.example.finalexam.model.service.UserServiceModel;
import com.example.finalexam.model.view.SongViewModel;

import java.util.List;

public interface SongService {
    boolean isFreeName(String performer);

    void addSong(SongServiceModel songServiceModel, UserServiceModel user);

    List<SongViewModel> findByStyleName(StyleName pop);


    Song findById(Long id);
}

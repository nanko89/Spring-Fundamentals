package com.example.mymusicdb.service;

import com.example.mymusicdb.model.service.AlbumServiceModel;
import com.example.mymusicdb.model.service.UserServiceModel;
import com.example.mymusicdb.model.view.AlbumViewModel;

import java.util.List;

public interface AlbumService {
    void addAlbum(AlbumServiceModel albumServiceModel, UserServiceModel userServiceModel);

    Integer sumCopies();

    List<AlbumViewModel> findAllAlbumView();

    void deleteAlbum(Long id);
}

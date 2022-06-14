package com.example.mymusicdb.service.impl;

import com.example.mymusicdb.model.entity.Album;
import com.example.mymusicdb.model.entity.Artist;
import com.example.mymusicdb.model.entity.User;
import com.example.mymusicdb.model.service.AlbumServiceModel;
import com.example.mymusicdb.model.service.UserServiceModel;
import com.example.mymusicdb.model.view.AlbumViewModel;
import com.example.mymusicdb.repository.AlbumRepository;
import com.example.mymusicdb.service.AlbumService;
import com.example.mymusicdb.service.ArtistService;
import com.example.mymusicdb.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;
    private final ArtistService artistService;
    private final UserService userService;
    private final ModelMapper modelMapper;


    public AlbumServiceImpl(AlbumRepository albumRepository, ArtistService artistService, ModelMapper modelMapper, UserService userService) {
        this.albumRepository = albumRepository;
        this.artistService = artistService;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @Override
    public void addAlbum(AlbumServiceModel albumServiceModel, UserServiceModel userServiceModel) {
        User user = userService
                .findByUsername(userServiceModel.getUsername());

        Artist artist = artistService
                .findByArtistName(albumServiceModel.getArtist());

        Album album = modelMapper
                .map(albumServiceModel, Album.class);

        album.setAddedFrom(user).setArtist(artist);

        albumRepository.save(album);
    }

    @Override
    public Integer sumCopies() {
        return albumRepository.findAll()
                .stream()
                .mapToInt(Album::getCopies)
                .sum();
    }

    @Override
    public List<AlbumViewModel> findAllAlbumView() {
        return albumRepository.findAll()
                .stream()
                .map(album -> {
                    AlbumViewModel viewModel = modelMapper.map(album, AlbumViewModel.class);
                    viewModel.setArtist(album.getArtist().getName().name());
                    viewModel.setGenre(album.getGenre().name());
                    return viewModel;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAlbum(Long id) {
        albumRepository.deleteById(id);
    }
}

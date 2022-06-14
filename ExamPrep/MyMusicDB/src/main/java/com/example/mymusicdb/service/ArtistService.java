package com.example.mymusicdb.service;

import com.example.mymusicdb.model.entity.Artist;
import com.example.mymusicdb.model.entity.enums.ArtistName;

public interface ArtistService {
    void initArtist();

    Artist findByArtistName(ArtistName artist);
}

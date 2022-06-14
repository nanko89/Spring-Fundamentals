package com.example.mymusicdb.init;

import com.example.mymusicdb.service.ArtistService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataBaseInit implements CommandLineRunner {

    private final ArtistService artistService;

    public DataBaseInit(ArtistService artistService) {
        this.artistService = artistService;
    }

    @Override
    public void run(String... args)  {
        artistService.initArtist();
    }
}

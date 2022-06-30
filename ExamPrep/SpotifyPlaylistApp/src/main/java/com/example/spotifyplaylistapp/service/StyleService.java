package com.example.spotifyplaylistapp.service;

import com.example.spotifyplaylistapp.model.entity.Style;
import com.example.spotifyplaylistapp.model.entity.enums.StyleName;

public interface StyleService {
    void initStyles();

    Style findByStyleName(StyleName style);
}

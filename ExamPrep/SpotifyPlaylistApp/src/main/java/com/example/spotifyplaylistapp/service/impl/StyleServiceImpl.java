package com.example.spotifyplaylistapp.service.impl;

import com.example.spotifyplaylistapp.model.entity.Style;
import com.example.spotifyplaylistapp.model.entity.enums.StyleName;
import com.example.spotifyplaylistapp.repository.StyleRepository;
import com.example.spotifyplaylistapp.service.StyleService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class StyleServiceImpl implements StyleService {

    private final StyleRepository styleRepository;

    public StyleServiceImpl(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }

    @Override
    public void initStyles() {
        if (styleRepository.count() == 0) {
            Arrays.stream(StyleName.values())
                    .forEach(styleName -> {
                        Style style = new Style();
                        style.setName(styleName)
                                .setDescription("Description for style " + styleName.name().toLowerCase());

                        styleRepository.save(style);
                    });
        }
    }

    @Override
    public Style findByStyleName(StyleName style) {
        return styleRepository
                .findByName(style)
                .orElse(null);
    }
}

package com.example.finalexam.service.impl;

import com.example.finalexam.model.entity.Style;
import com.example.finalexam.model.entity.enums.StyleName;
import com.example.finalexam.repository.StyleRepository;
import com.example.finalexam.service.StyleService;
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
                                .setDescription("Description for " + styleName.name().toLowerCase() + ".");

                        this.styleRepository.save(style);
                    });
        }
    }

    @Override
    public Style findByStyleName(StyleName style) {
        return this.styleRepository
                .findByName(style)
                .orElse(null);
    }
}

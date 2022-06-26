package com.example.finalexam.service;

import com.example.finalexam.model.entity.Style;
import com.example.finalexam.model.entity.enums.StyleName;

public interface StyleService {
    void initStyles();

    Style findByStyleName(StyleName style);
}

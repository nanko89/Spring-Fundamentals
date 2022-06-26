package com.example.finalexam.init;

import com.example.finalexam.service.StyleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataBaseInit implements CommandLineRunner {

    private final StyleService styleService;

    public DataBaseInit(StyleService styleService) {
        this.styleService = styleService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.styleService.initStyles();
    }
}

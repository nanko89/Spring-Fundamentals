package com.example.heroes.service.impl;

import com.example.heroes.repository.HeroRepository;
import com.example.heroes.service.HeroService;
import org.springframework.stereotype.Service;

@Service
public class HeroServiceImpl implements HeroService {

    private final HeroRepository heroRepository;

    public HeroServiceImpl(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }
    @Override
    public boolean isFreeName(String name) {
        return this.heroRepository
                .findByNameIgnoreCase(name)
                .isEmpty();
    }
}

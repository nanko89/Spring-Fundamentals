package com.example.heroes.service;

import com.example.heroes.model.service.HeroServiceModel;
import com.example.heroes.model.view.HeroInfoView;
import com.example.heroes.model.view.HeroHomeView;

import java.util.List;

public interface HeroService {
    boolean isFreeName(String name);


    void createHero(HeroServiceModel heroServiceModel);

    List<HeroHomeView> getAllHero();

    HeroInfoView findHeroById(Long id);

    void deleteHero(Long id);
}

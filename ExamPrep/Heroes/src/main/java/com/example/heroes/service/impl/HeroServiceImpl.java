package com.example.heroes.service.impl;

import com.example.heroes.model.entity.Hero;
import com.example.heroes.model.service.HeroServiceModel;
import com.example.heroes.model.view.HeroInfoView;
import com.example.heroes.model.view.HeroHomeView;
import com.example.heroes.repository.HeroRepository;
import com.example.heroes.service.HeroService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HeroServiceImpl implements HeroService {

    private final HeroRepository heroRepository;
    private final ModelMapper modelMapper;

    public HeroServiceImpl(HeroRepository heroRepository, ModelMapper modelMapper) {
        this.heroRepository = heroRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean isFreeName(String name) {
        return this.heroRepository
                .findByNameIgnoreCase(name)
                .isEmpty();
    }

    @Override
    public void createHero(HeroServiceModel heroServiceModel) {

        Hero hero = modelMapper
                .map(heroServiceModel, Hero.class);

        heroRepository.save(hero);
    }

    @Override
    public List<HeroHomeView> getAllHero() {
        return heroRepository.findAll()
                .stream()
                .map(hero -> modelMapper.map(hero, HeroHomeView.class))
                .collect(Collectors.toList());
    }

    @Override
    public HeroInfoView findHeroById(Long id) {
        return modelMapper
                .map(heroRepository.findById(id).get(), HeroInfoView.class);
    }

    @Override
    public void deleteHero(Long id) {
        heroRepository.deleteById(id);
    }
}

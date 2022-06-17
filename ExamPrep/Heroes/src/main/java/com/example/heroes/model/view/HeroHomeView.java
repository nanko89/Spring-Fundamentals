package com.example.heroes.model.view;

public class HeroHomeView {
    private Long id;
    private String name;
    private String heroClass;

    public HeroHomeView() {
    }

    public Long getId() {
        return id;
    }

    public HeroHomeView setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public HeroHomeView setName(String name) {
        this.name = name;
        return this;
    }

    public String getHeroClass() {
        return heroClass;
    }

    public HeroHomeView setHeroClass(String heroClass) {
        this.heroClass = heroClass;
        return this;
    }
}

package com.example.heroes.model.view;

public class HeroInfoView {
    private Long id;
    private String name;
    private String heroClass;
    private Integer level;

    public HeroInfoView() {
    }

    public Long getId() {
        return id;
    }

    public HeroInfoView setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public HeroInfoView setName(String name) {
        this.name = name;
        return this;
    }

    public String getHeroClass() {
        return heroClass;
    }

    public HeroInfoView setHeroClass(String heroClass) {
        this.heroClass = heroClass;
        return this;
    }

    public Integer getLevel() {
        return level;
    }

    public HeroInfoView setLevel(Integer level) {
        this.level = level;
        return this;
    }
}

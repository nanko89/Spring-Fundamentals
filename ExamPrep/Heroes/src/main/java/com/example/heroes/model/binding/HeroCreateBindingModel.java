package com.example.heroes.model.binding;

import com.example.heroes.model.entity.enums.HeroClass;
import com.example.heroes.model.validation.UniqueName;

import javax.validation.constraints.NotNull;

public class HeroCreateBindingModel {
    @NotNull
    @UniqueName
    private String name;
    @NotNull
    private HeroClass heroClass;
    @NotNull
    private Integer level;

    public HeroCreateBindingModel() {
    }

    public String getName() {
        return name;
    }

    public HeroCreateBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public HeroClass getHeroClass() {
        return heroClass;
    }

    public HeroCreateBindingModel setHeroClass(HeroClass heroClass) {
        this.heroClass = heroClass;
        return this;
    }

    public Integer getLevel() {
        return level;
    }

    public HeroCreateBindingModel setLevel(Integer level) {
        this.level = level;
        return this;
    }
}

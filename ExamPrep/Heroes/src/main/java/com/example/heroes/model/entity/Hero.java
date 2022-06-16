package com.example.heroes.model.entity;

import com.example.heroes.model.entity.enums.HeroClass;

import javax.persistence.*;

@Entity
@Table(name = "heroes")
public class Hero extends BaseEntity {
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @Enumerated(EnumType.STRING)
    private HeroClass heroClass;
    @Column(name = "level", nullable = false)
    private Integer level;

    public Hero() {
    }

    public String getName() {
        return name;
    }

    public Hero setName(String name) {
        this.name = name;
        return this;
    }

    public HeroClass getHeroClass() {
        return heroClass;
    }

    public Hero setHeroClass(HeroClass heroClass) {
        this.heroClass = heroClass;
        return this;
    }

    public Integer getLevel() {
        return level;
    }

    public Hero setLevel(Integer level) {
        this.level = level;
        return this;
    }
}

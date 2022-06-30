package com.example.spotifyplaylistapp.model.entity;

import com.example.spotifyplaylistapp.model.entity.enums.StyleName;

import javax.persistence.*;

@Entity
@Table(name = "styles")
public class Style extends BaseEntity{
    @Column(name = "name", unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private StyleName name;
    @Column(name = "description")
    private String description;

    public Style() {
    }

    public StyleName getName() {
        return name;
    }

    public Style setName(StyleName name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Style setDescription(String description) {
        this.description = description;
        return this;
    }
}

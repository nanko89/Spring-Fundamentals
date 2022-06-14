package com.example.mymusicdb.model.entity;

import com.example.mymusicdb.model.entity.enums.ArtistName;

import javax.persistence.*;

@Entity
@Table(name = "artists")
public class Artist extends BaseEntity {
    @Enumerated(EnumType.STRING)
    @Column(name = "name", nullable = false)
    private ArtistName name;
    @Column(name = "career_information", columnDefinition = "TEXT")
    private String careerInformation;

    public Artist() {
    }

    public ArtistName getName() {
        return name;
    }

    public Artist setName(ArtistName name) {
        this.name = name;
        return this;
    }

    public String getCareerInformation() {
        return careerInformation;
    }

    public Artist setCareerInformation(String careerInformation) {
        this.careerInformation = careerInformation;
        return this;
    }
}

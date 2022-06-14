package com.example.mymusicdb.model.service;

import com.example.mymusicdb.model.entity.Artist;
import com.example.mymusicdb.model.entity.User;
import com.example.mymusicdb.model.entity.enums.ArtistName;
import com.example.mymusicdb.model.entity.enums.Genre;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class AlbumServiceModel {
    private Long id;
    private String name;
    private String imageUrl;
    private String description;
    private Integer copies;
    private BigDecimal price;
    private LocalDate releasedDate;
    private String producer;
    private Genre genre;
    private ArtistName artist;

    public AlbumServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public AlbumServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AlbumServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public AlbumServiceModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AlbumServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getCopies() {
        return copies;
    }

    public AlbumServiceModel setCopies(Integer copies) {
        this.copies = copies;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AlbumServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDate getReleasedDate() {
        return releasedDate;
    }

    public AlbumServiceModel setReleasedDate(LocalDate releasedDate) {
        this.releasedDate = releasedDate;
        return this;
    }

    public String getProducer() {
        return producer;
    }

    public AlbumServiceModel setProducer(String producer) {
        this.producer = producer;
        return this;
    }

    public Genre getGenre() {
        return genre;
    }

    public AlbumServiceModel setGenre(Genre genre) {
        this.genre = genre;
        return this;
    }

    public ArtistName getArtist() {
        return artist;
    }

    public AlbumServiceModel setArtist(ArtistName artist) {
        this.artist = artist;
        return this;
    }

}

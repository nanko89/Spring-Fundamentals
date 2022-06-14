package com.example.mymusicdb.model.view;

import com.example.mymusicdb.model.entity.Artist;
import com.example.mymusicdb.model.entity.User;
import com.example.mymusicdb.model.entity.enums.Genre;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDate;

public class AlbumViewModel {
    private Long id;
    private String name;
    private String imageUrl;
    private Integer copies;
    private BigDecimal price;
    private LocalDate releasedDate;
    private String producer;
    private String genre;
    private String artist;

    public AlbumViewModel() {
    }

    public Long getId() {
        return id;
    }

    public AlbumViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AlbumViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public AlbumViewModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getCopies() {
        return copies;
    }

    public AlbumViewModel setCopies(Integer copies) {
        this.copies = copies;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AlbumViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDate getReleasedDate() {
        return releasedDate;
    }

    public AlbumViewModel setReleasedDate(LocalDate releasedDate) {
        this.releasedDate = releasedDate;
        return this;
    }

    public String getProducer() {
        return producer;
    }

    public AlbumViewModel setProducer(String producer) {
        this.producer = producer;
        return this;
    }

    public String getGenre() {
        return genre;
    }

    public AlbumViewModel setGenre(String genre) {
        this.genre = genre;
        return this;
    }

    public String getArtist() {
        return artist;
    }

    public AlbumViewModel setArtist(String artist) {
        this.artist = artist;
        return this;
    }
}

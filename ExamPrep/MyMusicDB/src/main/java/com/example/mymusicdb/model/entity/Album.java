package com.example.mymusicdb.model.entity;

import com.example.mymusicdb.model.entity.enums.Genre;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "albums")
public class Album extends BaseEntity {
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "image_url", nullable = false)
    private String imageUrl;
    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;
    @Column(name = "copies", nullable = false)
    private Integer copies;
    @Column(name = "price", nullable = false)
    private BigDecimal price;
    @Column(name = "released_date", nullable = false)
    private LocalDate releasedDate;
    @Column(name = "producer")
    private String producer;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @ManyToOne
    private Artist artist;
    @ManyToOne
    private User addedFrom;

    public Album() {
    }

    public String getName() {
        return name;
    }

    public Album setName(String name) {
        this.name = name;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Album setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Album setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getCopies() {
        return copies;
    }

    public Album setCopies(Integer copies) {
        this.copies = copies;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Album setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDate getReleasedDate() {
        return releasedDate;
    }

    public Album setReleasedDate(LocalDate releasedDate) {
        this.releasedDate = releasedDate;
        return this;
    }

    public String getProducer() {
        return producer;
    }

    public Album setProducer(String producer) {
        this.producer = producer;
        return this;
    }

    public Genre getGenre() {
        return genre;
    }

    public Album setGenre(Genre genre) {
        this.genre = genre;
        return this;
    }

    public Artist getArtist() {
        return artist;
    }

    public Album setArtist(Artist artist) {
        this.artist = artist;
        return this;
    }

    public User getAddedFrom() {
        return addedFrom;
    }

    public Album setAddedFrom(User addedFrom) {
        this.addedFrom = addedFrom;
        return this;
    }
}

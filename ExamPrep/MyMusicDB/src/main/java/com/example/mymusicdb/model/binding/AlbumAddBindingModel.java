package com.example.mymusicdb.model.binding;

import com.example.mymusicdb.model.entity.Artist;
import com.example.mymusicdb.model.entity.User;
import com.example.mymusicdb.model.entity.enums.ArtistName;
import com.example.mymusicdb.model.entity.enums.Genre;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class AlbumAddBindingModel {
    @NotBlank
    @Size(min = 3, max = 20)
    private String name;
    @NotBlank
    @Size(min = 5)
    private String imageUrl;
    @NotBlank
    @Size(min = 5)
    private String description;
    @NotNull
    @Min(5)
    private Integer copies;
    @NotNull
    @PositiveOrZero
    private BigDecimal price;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
    @NotNull
    private LocalDate releasedDate;
    private String producer;
    @NotNull
    private Genre genre;
    @NotNull
    private ArtistName artist;

    public AlbumAddBindingModel() {
    }

    public String getName() {
        return name;
    }

    public AlbumAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public AlbumAddBindingModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AlbumAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getCopies() {
        return copies;
    }

    public AlbumAddBindingModel setCopies(Integer copies) {
        this.copies = copies;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AlbumAddBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDate getReleasedDate() {
        return releasedDate;
    }

    public AlbumAddBindingModel setReleasedDate(LocalDate releasedDate) {
        this.releasedDate = releasedDate;
        return this;
    }

    public String getProducer() {
        return producer;
    }

    public AlbumAddBindingModel setProducer(String producer) {
        this.producer = producer;
        return this;
    }

    public Genre getGenre() {
        return genre;
    }

    public AlbumAddBindingModel setGenre(Genre genre) {
        this.genre = genre;
        return this;
    }

    public ArtistName getArtist() {
        return artist;
    }

    public AlbumAddBindingModel setArtist(ArtistName artist) {
        this.artist = artist;
        return this;
    }
}

package com.example.spotifyplaylistapp.model.dto;


import com.example.spotifyplaylistapp.model.entity.enums.StyleName;
import com.example.spotifyplaylistapp.validation.UniqueName;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class SongAddDTO {

    private Long id;
    @NotBlank
    @UniqueName
    @Size(min = 3, max = 20)
    private String performer;
    @NotBlank
    @Size(min = 2, max = 20)
    private String title;
    @NotNull
    @Positive
    private Integer duration;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
    private LocalDate releaseDate;
    @NotNull
    private StyleName style;

    public SongAddDTO() {
    }

    public Long getId() {
        return id;
    }

    public SongAddDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getPerformer() {
        return performer;
    }

    public SongAddDTO setPerformer(String performer) {
        this.performer = performer;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public SongAddDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public Integer getDuration() {
        return duration;
    }

    public SongAddDTO setDuration(Integer duration) {
        this.duration = duration;
        return this;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public SongAddDTO setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public StyleName getStyle() {
        return style;
    }

    public SongAddDTO setStyle(StyleName style) {
        this.style = style;
        return this;
    }
}

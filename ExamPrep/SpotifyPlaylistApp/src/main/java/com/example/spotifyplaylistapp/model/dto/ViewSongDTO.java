package com.example.spotifyplaylistapp.model.dto;

public class ViewSongDTO {

    private Long id;
    private String performer;
    private String title;
    private String duration;


    public ViewSongDTO() {
    }

    public Long getId() {
        return id;
    }

    public ViewSongDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getPerformer() {
        return performer;
    }

    public ViewSongDTO setPerformer(String performer) {
        this.performer = performer;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ViewSongDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDuration() {
        return duration;
    }

    public ViewSongDTO setDuration(String duration) {
        this.duration = duration;
        return this;
    }
}

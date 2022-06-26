package com.example.finalexam.model.view;


public class SongViewModel {
    private Long id;

    private String performer;

    private String title;

    private Float duration;

    public SongViewModel() {
    }

    public Long getId() {
        return id;
    }

    public SongViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getPerformer() {
        return performer;
    }

    public SongViewModel setPerformer(String performer) {
        this.performer = performer;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public SongViewModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public Float getDuration() {
        return duration;
    }

    public SongViewModel setDuration(Float duration) {
        this.duration = duration;
        return this;
    }
}

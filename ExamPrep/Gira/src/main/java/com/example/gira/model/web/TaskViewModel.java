package com.example.gira.model.web;

import com.example.gira.model.entity.Classification;
import com.example.gira.model.entity.User;
import com.example.gira.model.entity.enums.Progress;

import java.time.LocalDate;

public class TaskViewModel {
    private Long id;
    private String name;
    private String description;
    private Progress progress;
    private LocalDate dueDate;
    private Classification classification;
    private User user;

    public TaskViewModel() {
    }

    public Long getId() {
        return id;
    }

    public TaskViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TaskViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TaskViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public Progress getProgress() {
        return progress;
    }

    public TaskViewModel setProgress(Progress progress) {
        this.progress = progress;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public TaskViewModel setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public Classification getClassification() {
        return classification;
    }

    public TaskViewModel setClassification(Classification classification) {
        this.classification = classification;
        return this;
    }

    public User getUser() {
        return user;
    }

    public TaskViewModel setUser(User user) {
        this.user = user;
        return this;
    }
}

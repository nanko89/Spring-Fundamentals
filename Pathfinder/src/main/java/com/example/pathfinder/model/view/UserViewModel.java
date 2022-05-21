package com.example.pathfinder.model.view;

import com.example.pathfinder.model.entity.enums.Level;

public class UserViewModel {
    private Long id;
    private Level level;
    private String fullName;
    private String username;
    private Integer age;

    public UserViewModel() {
    }

    public Long getId() {
        return id;
    }

    public UserViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public Level getLevel() {
        return level;
    }

    public UserViewModel setLevel(Level level) {
        this.level = level;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserViewModel setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserViewModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserViewModel setAge(Integer age) {
        this.age = age;
        return this;
    }
}

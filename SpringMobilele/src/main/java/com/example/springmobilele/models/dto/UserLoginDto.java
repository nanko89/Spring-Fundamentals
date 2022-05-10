package com.example.springmobilele.models.dto;

public class UserLoginDto {

    private String username;
    private String password;

    public UserLoginDto() {
    }

    public String getUsername() {
        return username;
    }

    public UserLoginDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginDto setPassword(String password) {
        this.password = password;
        return this;
    }
}

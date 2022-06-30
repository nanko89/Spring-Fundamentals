package com.example.spotifyplaylistapp.model.dto;

import com.example.spotifyplaylistapp.validation.UniqueEmail;
import com.example.spotifyplaylistapp.validation.UniqueUsername;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserRegisterDTO {
    private Long id;
    @NotBlank
    @Size(min = 3, max = 20)
    @UniqueUsername
    private String username;
    @NotBlank
    @Size(min = 3, max = 20)
    private String password;
    @NotBlank
    @Size(min = 3, max = 20)
    private String confirmPassword;
    @NotBlank
    @Email
    @UniqueEmail
    private String email;

    public UserRegisterDTO() {
    }

    public Long getId() {
        return id;
    }

    public UserRegisterDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterDTO setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterDTO setEmail(String email) {
        this.email = email;
        return this;
    }
}

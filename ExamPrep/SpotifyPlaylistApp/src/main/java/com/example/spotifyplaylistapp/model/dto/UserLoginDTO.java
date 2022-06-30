package com.example.spotifyplaylistapp.model.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserLoginDTO {

    private Long id;
    @NotBlank(message = "Username can not be empty!")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters")
    private String username;
    @NotBlank(message = "Password can not be empty!")
    @Size(min = 3, max = 20, message = "Password must be between 3 and 20 characters")
    private String password;

    public UserLoginDTO() {
    }


    public Long getId() {
        return id;
    }

    public UserLoginDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserLoginDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginDTO setPassword(String password) {
        this.password = password;
        return this;
    }
}

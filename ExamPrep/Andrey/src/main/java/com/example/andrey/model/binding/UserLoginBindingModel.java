package com.example.andrey.model.binding;

import com.example.andrey.model.validation.UniqueUsername;

import javax.validation.constraints.NotBlank;

public class UserLoginBindingModel {
    @NotBlank
    private String username;
    @NotBlank
    private String password;

    public UserLoginBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public UserLoginBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }
}

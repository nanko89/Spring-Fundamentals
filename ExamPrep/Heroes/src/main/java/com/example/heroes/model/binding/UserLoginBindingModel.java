package com.example.heroes.model.binding;

import javax.validation.constraints.NotNull;

public class UserLoginBindingModel {
    @NotNull(message = "Username not be empty")
    private String username;
    @NotNull(message = "Password not be empty")
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

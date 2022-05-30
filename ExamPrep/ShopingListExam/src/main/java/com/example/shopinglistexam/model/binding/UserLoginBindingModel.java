package com.example.shopinglistexam.model.binding;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserLoginBindingModel {
    @NotBlank
    @Size(min=3, max = 20, message = "Username must be between 3 and 20 symbols.")
    private String username;
    @NotBlank
    @Size(min=3, max = 20, message = "Password must be between 3 and 20 symbols.")
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

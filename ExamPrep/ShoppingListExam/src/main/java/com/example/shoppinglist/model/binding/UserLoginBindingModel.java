package com.example.shoppinglist.model.binding;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserLoginBindingModel {
    @NotBlank( message = "Username must not be empty")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters!")
    private String username;
    @NotBlank(message = "Password must not be empty")
    @Size(min = 3, max = 20, message = "Password must be between 3 and 20 characters!")
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

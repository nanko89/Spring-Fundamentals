package com.example.andrey.model.binding;

import com.example.andrey.model.validation.UniqueEmail;
import com.example.andrey.model.validation.UniqueUsername;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserRegisterBindingModel {
    @NotBlank(message = "Username must not be empty")
    @UniqueUsername
    private String username;
    @NotBlank(message = "Password must not be empty")
    private String password;
    @NotBlank(message = "Email must not be empty")
    @Email(message = "Invalid email")
    @UniqueEmail
    private String email;

    @NotBlank
    private String confirmPassword;

    public UserRegisterBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}

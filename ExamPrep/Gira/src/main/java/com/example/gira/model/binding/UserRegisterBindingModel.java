package com.example.gira.model.binding;

import com.example.gira.model.validation.UniqueEmail;
import com.example.gira.model.validation.UniqueUsername;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserRegisterBindingModel {
    @NotBlank(message = "Email not be empty")
    @Email(message = "Must be a well-formed email address" )
    @UniqueEmail
    private String email;

    @NotBlank(message = "Username not be empty")
    @Size(min = 3, max = 20, message = "Username length must be between 3 and 20 characters")
    @UniqueUsername
    private String username;
    @NotBlank(message = "Password not be empty")
    @Size(min = 3, max = 20, message = "Password length must be between 3 and 20 characters")
    private String password;
    @NotBlank
    @Size(min = 3, max = 20)
    private String confirmPassword;

    public UserRegisterBindingModel() {
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterBindingModel setEmail(String email) {
        this.email = email;
        return this;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}

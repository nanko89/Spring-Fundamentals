package com.example.battleships.model.binding;

import com.example.battleships.model.validator.UniqueEmail;
import com.example.battleships.model.validator.UniqueUsername;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserRegisterBindingModel {
    @NotBlank
    @Size(min = 3, max = 10)
    @UniqueUsername(message = "Username already exist")
    private String username;
    @NotBlank
    @Size(min = 5, max = 20)
    private String fullName;
    @NotBlank
    @Email
    @UniqueEmail(message = "Email already exist")
    private String email;
    @NotBlank
    @Size(min = 3)
    private String password;
    @NotBlank
    @Size(min = 3)
    private String confirmPassword;

    public UserRegisterBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}

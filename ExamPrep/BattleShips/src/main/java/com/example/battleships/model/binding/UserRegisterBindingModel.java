package com.example.battleships.model.binding;

import com.example.battleships.model.validator.UniqueEmail;
import com.example.battleships.model.validator.UniqueUsername;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserRegisterBindingModel {
    @NotBlank(message = "Username must not be empty!")
    @Size(min = 3, max = 10, message = "Username length must be between 5 and 20 characters.")
    @UniqueUsername(message = "Username already exist")
    private String username;
    @NotBlank(message = "Full name must not be empty!")
    @Size(min = 5, max = 20, message = "Full name length must be between 5 and 20 characters.")
    private String fullName;
    @NotBlank(message = "Email must not be empty!")
    @Email(message = "Invalid email")
    @UniqueEmail(message = "Email already exist")
    private String email;
    @NotBlank(message = "Password must not be empty!")
    @Size(min = 3, message = "Password length must be more than 3 characters long.")
    private String password;
    @NotBlank(message = "Confirm password must not be empty!")
    @Size(min = 3, message = "Confirm password length must be more than 3 characters long.")
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

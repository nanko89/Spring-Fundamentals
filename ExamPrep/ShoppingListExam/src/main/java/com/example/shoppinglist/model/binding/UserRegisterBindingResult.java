package com.example.shoppinglist.model.binding;

import com.example.shoppinglist.model.validation.UniqueEmail;
import com.example.shoppinglist.model.validation.UniqueUsername;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserRegisterBindingResult {

    @NotBlank( message = "Username must not be empty")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters!")
    @UniqueUsername
    private String username;
    @NotBlank(message = "Password must not be empty")
    @Size(min = 3, max = 20, message = "Password must be between 3 and 20 characters!")
    private String password;

    @Email(message = "Invalid email")
    @UniqueEmail
    @NotBlank(message = "Email must not be empty")
    private String email;
    @NotBlank
    @Size(min = 3, max = 20)
    private String confirmPassword;

    public UserRegisterBindingResult() {
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterBindingResult setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterBindingResult setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterBindingResult setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterBindingResult setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}

package com.example.mymusicdb.model.binding;

import com.example.mymusicdb.model.validator.UniqueEmail;
import com.example.mymusicdb.model.validator.UniqueUsername;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRegisterBindingModel {

    @NotBlank(message = "Username must not be empty")
    @Size(min = 3, max = 20, message = "Username length must be between than 3 and 20 characters")
    @UniqueUsername
    private String username;
    @NotBlank
    @Size(min = 3, max = 20)
    private String fullName;
    @NotBlank
    @Size(min = 5, max = 20)
    private String password;
    @NotBlank
    @Size(min = 5, max = 20)
    private String confirmPassword;
    @Email(message = "Email must be valid")
    @NotNull(message = "Email must not be empty")
    @UniqueEmail
    private String email;

    public UserRegisterBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserRegisterBindingModel setFullName(String fullName) {
        this.fullName = fullName;
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

    public String getEmail() {
        return email;
    }

    public UserRegisterBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }
}

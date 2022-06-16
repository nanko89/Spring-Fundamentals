package com.example.gira.model.binding;

import com.example.gira.model.validation.UniqueEmail;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserLoginBindingModel {
    @NotBlank(message = "Email not be blank")
    @Email(message = "Must be a well-formed email address" )
    private String email;
    @NotBlank(message = "Password not be blank")
    @Size(min = 3, max = 20, message = "Password length must be between 3 and 20 characters")
    private String password;

    public UserLoginBindingModel() {
    }

    public String getEmail() {
        return email;
    }

    public UserLoginBindingModel setEmail(String email) {
        this.email = email;
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

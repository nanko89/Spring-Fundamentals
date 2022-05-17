package com.example.springmobilele.models.binding;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRegistrationDto {

    @NotNull
    @Size(min = 4, max = 20)
    private String firstName;
    @NotNull
    @Size(min = 4, max = 20)
    private String lastName;
//    @Size(min = 6, max = 20)
    private String username;
//    @Size(min = 8, max = 30)
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public UserRegistrationDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRegistrationDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserRegistrationDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegistrationDto setPassword(String password) {
        this.password = password;
        return this;
    }
}
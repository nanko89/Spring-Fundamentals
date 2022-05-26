package com.example.coffeeshop.model.biding;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class UserRegisterBidingModel {

    @Size(min = 5, max = 20 )
    private String username;

    private String firstName;

    @Size(min = 5, max = 20)
    private String lastName;

    @Email
    private String email;

    @Size(min = 3)
    private String password;
    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public UserRegisterBidingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserRegisterBidingModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRegisterBidingModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterBidingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterBidingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterBidingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}

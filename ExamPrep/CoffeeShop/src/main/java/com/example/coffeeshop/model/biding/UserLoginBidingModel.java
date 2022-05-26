package com.example.coffeeshop.model.biding;

import javax.validation.constraints.Size;

public class UserLoginBidingModel {


    @Size(min = 5, max = 20 )
    private String username;

    @Size(min = 3)
    private String password;

    public String getUsername() {
        return username;
    }

    public UserLoginBidingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginBidingModel setPassword(String password) {
        this.password = password;
        return this;
    }
}

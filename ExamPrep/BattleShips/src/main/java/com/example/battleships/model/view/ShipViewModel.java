package com.example.battleships.model.view;

import com.example.battleships.model.service.UserServiceModel;

public class ShipViewModel {

    private Long id;
    private String name;
    private Integer power;
    private Integer health;

    private UserServiceModel user;

    public ShipViewModel() {
    }

    public Long getId() {
        return id;
    }

    public ShipViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ShipViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getPower() {
        return power;
    }

    public ShipViewModel setPower(Integer power) {
        this.power = power;
        return this;
    }

    public Integer getHealth() {
        return health;
    }

    public ShipViewModel setHealth(Integer health) {
        this.health = health;
        return this;
    }

    public UserServiceModel getUser() {
        return user;
    }

    public ShipViewModel setUser(UserServiceModel user) {
        this.user = user;
        return this;
    }
}

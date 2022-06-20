package com.example.coffeeshop.model.entity.enums;

public enum CategoryName {
    COFFEE (2),
    CAKE (10),
    DRINK(1),
    OTHER(5);

    private final int time;

    CategoryName(int time) {
        this.time = time;
    }

    public int getTime() {
        return time;
    }
}



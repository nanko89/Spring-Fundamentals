package com.example.battleships.model.binding;

import com.example.battleships.model.entity.Category;
import com.example.battleships.model.validator.UniqueName;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class ShipAddBindingModel {
    @NotBlank
    @Size(min = 2, max = 10)
    @UniqueName(message = "Name is already exist")
    private String name;
    @NotNull
    @Positive
    private Integer power;
    @NotNull
    @Positive
    private Integer health;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @PastOrPresent
    private LocalDate created;
    @NotNull
    private String category;

    public ShipAddBindingModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public String getCategory() {
        return category;
    }

    public ShipAddBindingModel setCategory(String category) {
        this.category = category;
        return this;
    }
}

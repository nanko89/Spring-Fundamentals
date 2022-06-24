package com.example.battleships.model.binding;

import com.example.battleships.model.entity.enums.CategoryEnum;
import com.example.battleships.model.validation.UniqueName;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ShipAddBindingModel {
    @NotBlank
    @Size(min = 2, max = 10)
    @UniqueName
    private String name;
    @NotNull
    @Positive
    private Integer power;
    @NotNull
    @Positive
    private Integer health;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
    private LocalDate created;
    @NotNull
    private CategoryEnum category;

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

    public ShipAddBindingModel setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public ShipAddBindingModel setCategory(CategoryEnum category) {
        this.category = category;
        return this;
    }
}

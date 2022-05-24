package com.example.springmobilele.models.binding;

import com.example.springmobilele.models.entity.enums.Engine;
import com.example.springmobilele.models.entity.enums.Transmission;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class OfferUpdateBidingModel {

    private Long id;
    @NotBlank
    private String description;
    @NotNull
    private Engine engine;
    @NotBlank
    private String imageUrl;
    @NotNull
    @Positive
    private Integer mileage;
    @NotNull
    @Min(100)
    private BigDecimal price;
    @NotNull
    private Transmission transmission;
    @NotNull
    @Min(1950)
    private Integer year;

    public OfferUpdateBidingModel() {
    }

    public Long getId() {
        return id;
    }

    public OfferUpdateBidingModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferUpdateBidingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public Engine getEngine() {
        return engine;
    }

    public OfferUpdateBidingModel setEngine(Engine engine) {
        this.engine = engine;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferUpdateBidingModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public OfferUpdateBidingModel setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferUpdateBidingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public OfferUpdateBidingModel setTransmission(Transmission transmission) {
        this.transmission = transmission;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public OfferUpdateBidingModel setYear(Integer year) {
        this.year = year;
        return this;
    }
}

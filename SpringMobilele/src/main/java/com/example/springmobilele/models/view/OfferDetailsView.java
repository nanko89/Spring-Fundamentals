package com.example.springmobilele.models.view;

import com.example.springmobilele.models.entity.User;
import com.example.springmobilele.models.entity.enums.Engine;
import com.example.springmobilele.models.entity.enums.Transmission;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OfferDetailsView {
    private Long id;
    private String description;
    private Engine engine;
    private String imageUrl;
    private Integer mileage;
    private BigDecimal price;
    private Transmission transmission;
    private Integer year;
    private String model;
    private String brand;
    private LocalDateTime created;
    private LocalDateTime modified;
    private String fullName;

    public Long getId() {
        return id;
    }

    public OfferDetailsView setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferDetailsView setDescription(String description) {
        this.description = description;
        return this;
    }

    public Engine getEngine() {
        return engine;
    }

    public OfferDetailsView setEngine(Engine engine) {
        this.engine = engine;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferDetailsView setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public OfferDetailsView setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferDetailsView setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public OfferDetailsView setTransmission(Transmission transmission) {
        this.transmission = transmission;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public OfferDetailsView setYear(Integer year) {
        this.year = year;
        return this;
    }

    public String getModel() {
        return model;
    }

    public OfferDetailsView setModel(String model) {
        this.model = model;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public OfferDetailsView setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public OfferDetailsView setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public OfferDetailsView setModified(LocalDateTime modified) {
        this.modified = modified;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public OfferDetailsView setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }
}

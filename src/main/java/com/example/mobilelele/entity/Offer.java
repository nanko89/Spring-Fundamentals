package com.example.mobilelele.entity;

import com.example.mobilelele.entity.enums.Engine;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity{

    @Column(columnDefinition = "TEXT")
    private String description;
    @Enumerated
    private Engine engine;    //•	description – some text.
    //•	engine – enumerated value (GASOLINE, DIESEL, ELECTRIC, HYBRID).
    //•	imageUrl – the url of image.
    //•	mileage – a number.
    //•	price – the price of the offer.
    //•	transmission – enumerated value (MANUAL, AUTOMATIC).
    //•	year – the year of offered car.
    //•	created – a date and time.
    //•	modified – a date and time.
    //•	model – the model of a car.
    //•	seller – a user that sells the car.
}

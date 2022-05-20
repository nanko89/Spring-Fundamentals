package com.example.springmobilele.service.impl;

import com.example.springmobilele.models.entity.Offer;
import com.example.springmobilele.models.entity.enums.Engine;
import com.example.springmobilele.models.entity.enums.Transmission;
import com.example.springmobilele.models.view.OfferSummary;
import com.example.springmobilele.repository.OfferRepository;
import com.example.springmobilele.service.ModelService;
import com.example.springmobilele.service.OfferService;
import com.example.springmobilele.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final ModelService modelService;
    private final UserService userService;
    private final ModelMapper modelMapper;

    public OfferServiceImpl(OfferRepository offerRepository, ModelService modelService, UserService userService, ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.modelService = modelService;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }


    @Override
    public void initializeOffer() {

        if (offerRepository.count() == 0) {
            Offer firstOffer = new Offer();
            firstOffer
                    .setModel(modelService.findByName("x5"))
                    .setEngine(Engine.GASOLINE)
                    .setTransmission(Transmission.AUTOMATIC)
                    .setImageUrl("https://i.ebayimg.com/images/g/VSUAAOSwbYVighgb/s-l800.webp")
                    .setMileage(80000)
                    .setDescription("BMW X5 xDrive40i M Sport 5dr Auto [7 Seat] Automatic")
                    .setPrice(BigDecimal.valueOf(59000))
                    .setSeller(userService.findByUsername("admin"))
                    .setYear(2019);

            Offer secondOffer = new Offer();
            secondOffer
                    .setModel(modelService.findByName("x6"))
                    .setEngine(Engine.DIESEL)
                    .setTransmission(Transmission.AUTOMATIC)
                    .setImageUrl("https://img.hey.car/unsafe/1024x/filters:quality(90)/https://cdn.hey.car/images/cas/8a61261b4642d744ae7f17d79ac05ace/original.jpg")
                    .setMileage(120000)
                    .setDescription("BMW X6 xDrive30d HeadUp ACC Automatic")
                    .setPrice(BigDecimal.valueOf(49000))
                    .setSeller(userService.findByUsername("admin"))
                    .setYear(2017);

            offerRepository.saveAll(List.of(firstOffer, secondOffer));
        }
    }

    @Override
    public List<OfferSummary> getAllOffers() {
        return offerRepository
                .findAll()
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    private OfferSummary map(Offer offer) {
        return this.modelMapper.map(offer, OfferSummary.class);
    }
}

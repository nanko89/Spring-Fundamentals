package com.example.springmobilele.service.impl;

import com.example.springmobilele.models.entity.Offer;
import com.example.springmobilele.models.entity.enums.Engine;
import com.example.springmobilele.models.entity.enums.Transmission;
import com.example.springmobilele.models.view.OfferSummary;
import com.example.springmobilele.repository.OfferRepository;
import com.example.springmobilele.service.BrandService;
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
    private final BrandService brandService;
    private final UserService userService;
    private final ModelMapper modelMapper;

    public OfferServiceImpl(OfferRepository offerRepository, ModelService modelService, BrandService brandService, UserService userService, ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.modelService = modelService;
        this.brandService = brandService;
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
                    .setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/2/2b/2009_BMW_X6_xDrive35i.jpg/275px-2009_BMW_X6_xDrive35i.jpg")
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

    @Override
    public Offer getById(Long id) {
        return offerRepository.findById(id).orElse(null);
    }

    @Override
    public String findModel(Long id) {
        return offerRepository.findById(id).get().getModel().getName();
    }

    @Override
    public String findBrand(Long id) {
        return offerRepository.findById(id).get().getModel().getBrand().getName();
    }

    @Override
    public void deleteOffer(Long id) {
        offerRepository.deleteById(id);
    }

    private OfferSummary map(Offer offer) {
        return this.modelMapper.map(offer, OfferSummary.class);
    }
}

package com.example.springmobilele.service.impl;

import com.example.springmobilele.models.entity.Offer;
import com.example.springmobilele.models.view.OfferSummary;
import com.example.springmobilele.repository.OfferRepository;
import com.example.springmobilele.service.OfferService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;

    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }


    @Override
    public void initializeOffer() {
    //Todo:
    }

    @Override
    public List<OfferSummary> getAllOffers() {
        return offerRepository.findAll().stream().map(this::map).collect(Collectors.toList());
    }

    private OfferSummary map(Offer offer){

        //ToDO:
        return new OfferSummary();
    }
}

package com.example.springmobilele.service;

import com.example.springmobilele.models.entity.Offer;
import com.example.springmobilele.models.view.OfferSummary;

import java.util.List;

public interface OfferService {

    void initializeOffer();

    List<OfferSummary> getAllOffers();

    Offer getById(Long id);

    String findModel(Long id);

    String findBrand(Long id);

    void deleteOffer(Long id);
}

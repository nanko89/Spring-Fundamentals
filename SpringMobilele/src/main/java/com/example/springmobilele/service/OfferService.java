package com.example.springmobilele.service;

import com.example.springmobilele.models.entity.Offer;
import com.example.springmobilele.models.view.OfferSummary;

import java.util.List;

public interface OfferService {

    void initializeOffer();

    List<OfferSummary> getAllOffers();
 }

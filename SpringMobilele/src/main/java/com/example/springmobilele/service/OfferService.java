package com.example.springmobilele.service;

import com.example.springmobilele.models.service.OfferUpdateServiceModel;
import com.example.springmobilele.models.view.OfferDetailsView;
import com.example.springmobilele.models.view.OfferSummaryView;

import java.util.List;

public interface OfferService {

    void initializeOffer();

    List<OfferSummaryView> getAllOffers();

    void deleteOffer(Long id);

    void updateOffer(OfferUpdateServiceModel offerUpdateServiceModel);

    OfferDetailsView findById(Long id);

}

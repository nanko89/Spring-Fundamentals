package com.example.springmobilele.web;

import com.example.springmobilele.models.binding.OfferUpdateBidingModel;
import com.example.springmobilele.models.entity.enums.Engine;
import com.example.springmobilele.models.entity.enums.Transmission;
import com.example.springmobilele.models.service.OfferUpdateServiceModel;
import com.example.springmobilele.models.view.OfferDetailsView;
import com.example.springmobilele.models.view.OfferSummaryView;
import com.example.springmobilele.service.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class OffersController {

    private final OfferService offerService;
    private final ModelMapper modelMapper;

    public OffersController(OfferService offerService, ModelMapper modelMapper) {
        this.offerService = offerService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/offers/all")
    public String allOffers(Model model) {
        model.addAttribute("offers", offerService.getAllOffers());
        return "offers";
    }

    @GetMapping("/offers/{id}/details")
    public String showOfferDetails(@PathVariable Long id, Model model) {

        OfferDetailsView view = offerService.findById(id);

        model.addAttribute("offer", view)
                .addAttribute("brand", view.getBrand())
                .addAttribute("model", view.getModel());
        return "details";
    }

    @DeleteMapping("/offers/{id}")
    public String deleteOffer(@PathVariable Long id) {
        offerService.deleteOffer(id);
        return "redirect:/offers/all";
    }

    @GetMapping("/offers/{id}/update")
    public String updateOffer(@PathVariable Long id, Model model) {

        OfferDetailsView offerDetailsView = offerService.findById(id);

        OfferUpdateBidingModel offerModel = modelMapper
                .map(offerDetailsView, OfferUpdateBidingModel.class);

        model.addAttribute("offerModel", offerModel)
                .addAttribute("engines", Engine.values())
                .addAttribute("transmissions", Transmission.values());

        return "update";
    }

    @PatchMapping("/offers/{id}/update")
    public String updateOffer(@PathVariable Long id, OfferUpdateBidingModel offerUpdateBidingModel) {

        OfferUpdateServiceModel serviceModel = modelMapper
                .map(offerUpdateBidingModel, OfferUpdateServiceModel.class);

        serviceModel.setId(id);

        offerService.updateOffer(serviceModel);

        return "redirect:/offers/" + id + "/details";
    }
}

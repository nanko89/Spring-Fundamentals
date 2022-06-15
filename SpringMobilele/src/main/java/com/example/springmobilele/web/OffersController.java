package com.example.springmobilele.web;

import com.example.springmobilele.models.binding.OfferAddBidingModel;
import com.example.springmobilele.models.binding.OfferUpdateBidingModel;
import com.example.springmobilele.models.entity.enums.Engine;
import com.example.springmobilele.models.entity.enums.Transmission;
import com.example.springmobilele.models.service.OfferUpdateServiceModel;
import com.example.springmobilele.models.view.OfferDetailsView;
import com.example.springmobilele.service.BrandService;
import com.example.springmobilele.service.ModelService;
import com.example.springmobilele.service.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/offers")
public class OffersController {

    private final OfferService offerService;
    private final ModelMapper modelMapper;
    private final BrandService brandService;
    private final ModelService modelService;

    public OffersController(OfferService offerService, ModelMapper modelMapper, BrandService brandService, ModelService modelService) {
        this.offerService = offerService;
        this.modelMapper = modelMapper;
        this.brandService = brandService;
        this.modelService = modelService;
    }

    @GetMapping("/all")
    public String allOffers(Model model) {
        model.addAttribute("offers", offerService.getAllOffers());
        return "offers";
    }

    @GetMapping("/{id}/details")
    public String showOfferDetails(@PathVariable Long id, Model model) {

        OfferDetailsView view = offerService.findById(id);

        model.addAttribute("offer", view)
                .addAttribute("brand", view.getBrand())
                .addAttribute("model", view.getModel());
        return "details";
    }

    @DeleteMapping("/{id}")
    public String deleteOffer(@PathVariable Long id) {
        offerService.deleteOffer(id);
        return "redirect:/offers/all";
    }

    @GetMapping("/{id}/update")
    public String updateOffer(@PathVariable Long id, Model model) {

        OfferDetailsView offerDetailsView = offerService.findById(id);

        OfferUpdateBidingModel offerModel = modelMapper
                .map(offerDetailsView, OfferUpdateBidingModel.class);

        model
                .addAttribute("engines", Engine.values())
                .addAttribute("transmissions", Transmission.values())
                .addAttribute("offerModel", offerModel);

        return "update";
    }


    @GetMapping("/{id}/update/error")
    public String updateOfferErrors(@PathVariable Long id, Model model) {
        model
                .addAttribute("engines", Engine.values())
                .addAttribute("transmissions", Transmission.values());

        return "update";
    }

    @PatchMapping("/{id}/update")
    public String updateOffer(@PathVariable Long id,
                              @Valid @ModelAttribute("offerModel") OfferUpdateBidingModel offerModel,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("offerModel", offerModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.offerModel",
                            bindingResult);
            return "redirect:/offers/" + id + "/update/error";
        }

        OfferUpdateServiceModel serviceModel = modelMapper
                .map(offerModel, OfferUpdateServiceModel.class);

        serviceModel.setId(id);

        offerService.updateOffer(serviceModel);

        return "redirect:/offers/" + id + "/details";
    }


    @GetMapping("/add")
    public String addOffer(Model model){
        model
                .addAttribute("engines", Engine.values())
                .addAttribute("brands", brandService.getBrands())
                .addAttribute("transmissions", Transmission.values())
                .addAttribute("addOffer", new OfferAddBidingModel());
        return "offer-add";
    }

    @PostMapping("/add")
    public String saveOffer(@Valid OfferAddBidingModel offerAddBidingModel,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes
                    .addFlashAttribute("offerAddBidingModel", offerAddBidingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.offerAddBidingModel",
                            bindingResult);

            return "redirect:/add";
        }

       return "redirect:/" + offerAddBidingModel.getId() + "/details";
    }


}

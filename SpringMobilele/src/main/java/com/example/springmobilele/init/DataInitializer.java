package com.example.springmobilele.init;

import com.example.springmobilele.service.BrandService;
import com.example.springmobilele.service.ModelService;
import com.example.springmobilele.service.OfferService;
import com.example.springmobilele.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    private final BrandService brandService;
    private final ModelService modelService;
    private final UserService userService;
    private final OfferService offerService;

    public DataInitializer(BrandService brandService, ModelService modelService, UserService userService,
                           OfferService offerService) {
        this.brandService = brandService;
        this.modelService = modelService;
        this.userService = userService;
        this.offerService = offerService;
    }

    @Override
    public void run(String... args) {
        initializeBrandAndModels();
    }
    private void initializeBrandAndModels() {
        userService.initializeUserAndRole();
        brandService.initializeBrand();
        modelService.initializeModels();
        offerService.initializeOffer();
    }
}

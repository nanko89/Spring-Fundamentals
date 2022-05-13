package com.example.springmobilele.init;

import com.example.springmobilele.models.entity.Brand;
import com.example.springmobilele.models.entity.Model;
import com.example.springmobilele.models.entity.enums.Category;
import com.example.springmobilele.service.BrandService;
import com.example.springmobilele.service.ModelService;
import com.example.springmobilele.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {
    private final BrandService brandService;
    private final ModelService modelService;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(BrandService brandService, ModelService modelService, UserService userService, PasswordEncoder passwordEncoder) {
        this.brandService = brandService;
        this.modelService = modelService;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        initializeBrandAndModels();
    }
    private void initializeBrandAndModels() {

        userService.initializeUserAndRole();


    }
}

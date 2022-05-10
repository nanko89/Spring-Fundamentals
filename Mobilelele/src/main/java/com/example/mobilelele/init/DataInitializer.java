package com.example.mobilelele.init;

import com.example.mobilelele.models.entity.Brand;
import com.example.mobilelele.models.entity.Model;
import com.example.mobilelele.models.entity.User;
import com.example.mobilelele.models.entity.enums.Category;
import com.example.mobilelele.repository.BrandRepository;
import com.example.mobilelele.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Set;


@Component
public class DataInitializer implements CommandLineRunner {
    private final BrandRepository brandRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(BrandRepository brandRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.brandRepository = brandRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        initializeBrandAndModels();
        initializeUsers();
    }

    private void initializeUsers() {
        if (userRepository.count() == 0) {
            User admin = new User();
            admin.setActive(true)
                    .setFirstName("John")
                    .setLastName("Smith")
                    .setUsername("root")
                    .setPassword(passwordEncoder.encode("12345"));


            userRepository.save(admin);
        }
    }

    private void initializeBrandAndModels() {
        if (brandRepository.count() == 0) {
            Brand bmw = new Brand();
            bmw.setName("BMW").setCreated(LocalDateTime.now());

            Model x5 = new Model();
            x5.setBrand(bmw)
                    .setCategory(Category.CAR)
                    .setStartYear(1999)
                    .setImageUrl("https://cdn.motor1.com/images/mgl/P3G20A/s3/bmw-x5-m-facelift-rendering-by-kolesa.ru.jpg");


            Model x6 = new Model();
            x5.setBrand(bmw)
                    .setCategory(Category.CAR)
                    .setStartYear(2008)
                    .setImageUrl("https://carsalesbase.com/wp-content/uploads/2014/01/BMW_X6-auto-sales-statistics-Europe.jpg");


            bmw.setModels(Set.of(x5, x6));

            brandRepository.save(bmw);
        }
    }
}

package com.example.mobilelele.init;

import com.example.mobilelele.entity.Brand;
import com.example.mobilelele.entity.Model;
import com.example.mobilelele.entity.enums.Category;
import com.example.mobilelele.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DbInit implements CommandLineRunner {

    private final BrandRepository brandRepository;

    @Autowired
    public DbInit(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public void run(String... args){
            if (brandRepository.count() == 0){
                Brand bmw = new Brand().setName("BMW");

                Model x5 = new Model()
                        .setName("x5")
                        .setImageUrl("https://cdn.motor1.com/images/mgl/P3G20A/s3/bmw-x5-m-facelift-rendering-by-kolesa.ru.jpg")
                        .setStartYear(1999)
                        .setCategory(Category.CAR);

                Model x6 = new Model()
                        .setName("x6")
                        .setImageUrl("https://avtotachki.com/wp-content/uploads/2021/03/2020-bmw-x6-m-competition-f86-9-800x425.jpg")
                        .setStartYear(2008)
                        .setCategory(Category.CAR);

                bmw.setModels(List.of(x5, x6));
                x5.setBrand(bmw);
                x6.setBrand(bmw);

                brandRepository.save(bmw);

            }
    }
}

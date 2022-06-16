package com.example.heroes.model.validation;


import com.example.heroes.service.HeroService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueNameValidator implements ConstraintValidator<UniqueName, String> {

    private final HeroService herorService;

    public UniqueNameValidator(HeroService herorService) {
        this.herorService = herorService;
    }


    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {

        if (name == null){
            return true;
        }
        return herorService.isFreeName(name);
    }
}

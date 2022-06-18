package com.example.shoppinglist.model.validation;

import com.example.shoppinglist.service.ProductService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueNameValidator implements ConstraintValidator<UniqueName, String> {

   private final ProductService productService;

    public UniqueNameValidator(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {

        if (name == null){
            return true;
        }
        return this.productService.isFreeName(name);
    }
}

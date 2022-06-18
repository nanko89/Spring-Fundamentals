package com.example.shoppinglist.web;

import com.example.shoppinglist.model.binding.ProductAddBindingModel;
import com.example.shoppinglist.model.service.ProductServiceModel;
import com.example.shoppinglist.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final ModelMapper modelMapper;

    public ProductController(ProductService productService, ModelMapper modelMapper) {
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String add(){
        return "product-add";
    }

    @PostMapping("/add")
    public String confirmAdd(@Valid ProductAddBindingModel productAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("productAddBindingModel", productAddBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.productAddBindingModel",
                            bindingResult);
            return "redirect:add";
        }
        ProductServiceModel serviceModel = modelMapper
                .map(productAddBindingModel, ProductServiceModel.class);

        productService.addProduct(serviceModel);

        return "redirect:/";
    }


    @GetMapping("/buy/{id}")
    public String buyProduct(@PathVariable Long id){
        productService.buyProduct(id);
        return "redirect:/";
    }


    @GetMapping("/buy/all")
    public String buyAll(){
        productService.buyAll();
        return "redirect:/";
    }

    @ModelAttribute
    public ProductAddBindingModel productAddBindingModel(){
        return new ProductAddBindingModel();
    }
}

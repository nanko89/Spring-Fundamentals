package com.example.shopinglistexam.web;

import com.example.shopinglistexam.model.binding.ProductAddBindingModel;
import com.example.shopinglistexam.model.entity.enums.CategoryName;
import com.example.shopinglistexam.model.service.ProductServiceModel;
import com.example.shopinglistexam.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public String addProduct(Model model){
        if (!model.containsAttribute("productAddBindingModel")){
            model.addAttribute("productAddBindingModel", new ProductAddBindingModel())
                    .addAttribute("categories", CategoryName.values())
                    .addAttribute("existProductName", false);
        }
        return "product-add";
    }

    @PostMapping("/add")
    public String postAddProduct(@Valid ProductAddBindingModel productAddBindingModel,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("productAddBindingModel", productAddBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.productAddBindingModel", bindingResult);

        return "redirect:add";
        }

        ProductServiceModel serviceByName = productService.findByName(productAddBindingModel.getName());

        if (serviceByName != null){
            redirectAttributes.addFlashAttribute("productAddBindingModel", productAddBindingModel)
                    .addFlashAttribute("existProductName", true);
            return "redirect:add";
        }

        productService
                .addProduct(modelMapper.map(productAddBindingModel, ProductServiceModel.class));
        return "redirect:/";
    }
}

package com.example.andrey.web;

import com.example.andrey.model.binding.ProductAddBindingModel;
import com.example.andrey.model.service.ProductServiceModel;
import com.example.andrey.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final ModelMapper modelMapper;

    private final HttpSession httpSession;

    public ProductController(ProductService productService, ModelMapper modelMapper, HttpSession httpSession) {
        this.productService = productService;
        this.modelMapper = modelMapper;
        this.httpSession = httpSession;
    }

    @GetMapping("/add")
    public String add() {
        if (httpSession.getAttribute("user") == null){
            return "redirect:/";
        }
        return "add-product";
    }

    @PostMapping("/add")
    public String confirmAdd(@Valid ProductAddBindingModel productAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("productAddBindingModel", productAddBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.productAddBindingModel",
                            bindingResult);
            return "redirect:add";
        }

        productService
                .addProduct(modelMapper
                        .map(productAddBindingModel, ProductServiceModel.class));
        return "redirect:/";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Long id, Model model){
        model.addAttribute("product", productService.findProduct(id));
        return "details-product";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        productService.deleteProduct(id);
        return "redirect:/";
    }


    @ModelAttribute
    public ProductAddBindingModel productAddBindingModel() {
        return new ProductAddBindingModel();
    }
}

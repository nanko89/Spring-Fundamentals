package com.example.shopinglistexam.web;

import com.example.shopinglistexam.model.entity.enums.CategoryName;
import com.example.shopinglistexam.service.ProductService;
import jdk.jfr.Category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    private final ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String index(HttpSession httpSession, Model model){

        if(httpSession.getAttribute("user") == null){
            return "index";
        }

        model.addAttribute("totalSum", productService.getTotalSum());
        model.addAttribute("drinks", productService.findAllProductByCategoryName(CategoryName.DRINK));
        model.addAttribute("foods", productService.findAllProductByCategoryName(CategoryName.FOOD));
        model.addAttribute("households", productService.findAllProductByCategoryName(CategoryName.HOUSEHOLD));
        model.addAttribute("others", productService.findAllProductByCategoryName(CategoryName.OTHER));
        return "home";
    }

}

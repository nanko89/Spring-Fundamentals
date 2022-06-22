package com.example.andrey.web;

import com.example.andrey.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    private final HttpSession httpSession;
    private final ProductService productService;

    public HomeController(HttpSession httpSession, ProductService productService) {
        this.httpSession = httpSession;
        this.productService = productService;
    }

    @GetMapping("/")
    public String home(Model model) {
        if (httpSession.getAttribute("user") == null) {
            return "index";
        }

        model.addAttribute("products", productService.findAllProducts() );

        return "home";
    }

}

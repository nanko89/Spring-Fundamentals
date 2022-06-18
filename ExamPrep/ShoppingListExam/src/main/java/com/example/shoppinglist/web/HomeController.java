package com.example.shoppinglist.web;

import com.example.shoppinglist.model.entity.enums.CategoryName;
import com.example.shoppinglist.service.ProductService;
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

        model.addAttribute("totalSum", productService.findTotalSum());
        model.addAttribute("drinks", productService.findAllByCategoryName(CategoryName.DRINK));
        model.addAttribute("foods", productService.findAllByCategoryName(CategoryName.FOOD));
        model.addAttribute("households", productService.findAllByCategoryName(CategoryName.HOUSEHOLD));
        model.addAttribute("others", productService.findAllByCategoryName(CategoryName.OTHER));

        return "home";
    }
}

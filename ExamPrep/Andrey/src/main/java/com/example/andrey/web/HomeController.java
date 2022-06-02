package com.example.andrey.web;

import com.example.andrey.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    private final ItemService itemService;

    public HomeController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/")
    public String index(HttpSession httpSession, Model model){

        if(httpSession.getAttribute("user") == null){
            return "index";
        }

        model.addAttribute("items", itemService.findAllItems());
        return "home";
    }
}

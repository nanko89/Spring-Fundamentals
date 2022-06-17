package com.example.heroes.web;

import com.example.heroes.model.entity.User;
import com.example.heroes.service.HeroService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    private final HttpSession httpSession;
    private final ModelMapper modelMapper;

    private final HeroService heroService;

    public HomeController(HttpSession httpSession, ModelMapper modelMapper, HeroService heroService) {
        this.httpSession = httpSession;
        this.modelMapper = modelMapper;
        this.heroService = heroService;
    }

    @GetMapping("/")
    public String home(Model model){
        if (httpSession.getAttribute("user") == null){
            return "index";
        }

        User user = modelMapper
                .map(httpSession.getAttribute("user"), User.class);

        model.addAttribute("heroes", heroService.getAllHero());

        model.addAttribute("username", user.getUsername());

        return "home";
    }


}

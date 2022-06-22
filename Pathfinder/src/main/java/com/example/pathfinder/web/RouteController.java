package com.example.pathfinder.web;

import com.example.pathfinder.service.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/routes")
public class RouteController {

    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("")
    public String allRoutes(Model model){
        model.addAttribute("routes", routeService.findAllRoutesView());

        return "routes";
    }




}

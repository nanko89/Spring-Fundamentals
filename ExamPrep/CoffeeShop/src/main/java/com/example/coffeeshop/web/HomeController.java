package com.example.coffeeshop.web;

import com.example.coffeeshop.service.OrderService;
import com.example.coffeeshop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    private final HttpSession httpSession;
    private final OrderService orderService;
    private final UserService userService;

    public HomeController(HttpSession httpSession, OrderService orderService, UserService userService) {
        this.httpSession = httpSession;
        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String home(Model model) {

        if (httpSession.getAttribute("user") == null) {
            return "index";
        }

        model.addAttribute("totalTime", orderService.sumTotalTimeToOrder());
        model.addAttribute("employees", userService.getAllEmployees());
        model.addAttribute("order", orderService.getAllOrders());
        return "home";
    }


}

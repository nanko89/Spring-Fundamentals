package com.example.coffeeshop.web;

import com.example.coffeeshop.model.binding.OrderAddBindingModel;
import com.example.coffeeshop.model.service.OrderServiceModel;
import com.example.coffeeshop.model.service.UserServiceModel;
import com.example.coffeeshop.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private final ModelMapper modelMapper;
    private final HttpSession httpSession;

    public OrderController(OrderService orderService, ModelMapper modelMapper, HttpSession httpSession) {
        this.orderService = orderService;
        this.modelMapper = modelMapper;
        this.httpSession = httpSession;
    }

    @GetMapping("/add")
    private String add(){

        return "order-add";
    }

    @PostMapping("/add")
    public String confirmAdd(@Valid OrderAddBindingModel orderAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes
                    .addFlashAttribute("orderAddBindingModel", orderAddBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.orderAddBindingModel",
                            bindingResult);

            return "redirect:add";
        }

        UserServiceModel user = modelMapper.map(httpSession.getAttribute("user"), UserServiceModel.class);

        orderService
                .addOrder(modelMapper.map(orderAddBindingModel, OrderServiceModel.class), user);

        return "redirect:/";
    }


    @GetMapping("/ready/{id}")
    public String ready(@PathVariable Long id){

        orderService.readyOrder(id);
        return "redirect:/";
    }

    @ModelAttribute
    public OrderAddBindingModel orderAddBindingModel(){
        return new OrderAddBindingModel();
    }
}

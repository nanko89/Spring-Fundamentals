package com.example.coffeeshop.web;

import com.example.coffeeshop.model.biding.UserRegisterBidingModel;
import com.example.coffeeshop.model.service.UserServiceModel;
import com.example.coffeeshop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }


    @PostMapping("/register")
    public String registerConfirm(@Valid UserRegisterBidingModel userRegisterBidingModel,
                                  BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors() || !userRegisterBidingModel.getPassword()
                .equals(userRegisterBidingModel.getConfirmPassword())){

            redirectAttributes.addFlashAttribute("userRegisterBidingModel",
                    userRegisterBidingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBidingModel",
                    bindingResult);
            return "redirect:/users/register";
        }

        userService.registerUser(modelMapper.map(userRegisterBidingModel, UserServiceModel.class));

        return "redirect:/users/login";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @ModelAttribute("userRegisterBidingModel")
    public UserRegisterBidingModel userRegisterBidingModel(){
        return new UserRegisterBidingModel();
    }
}

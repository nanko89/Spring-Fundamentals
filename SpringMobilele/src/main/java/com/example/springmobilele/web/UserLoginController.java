package com.example.springmobilele.web;


import com.example.springmobilele.models.dto.UserLoginDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserLoginController {

    @GetMapping("/users/login")
    public String login(){
        return "auth-login";
    }

    @PostMapping("")
    public String login(UserLoginDto userLoginDto){

        return "redirect:/index";
    }
}

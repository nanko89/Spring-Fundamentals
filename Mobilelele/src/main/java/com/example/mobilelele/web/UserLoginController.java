package com.example.mobilelele.web;

import com.example.mobilelele.models.dto.UserLoginDto;
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

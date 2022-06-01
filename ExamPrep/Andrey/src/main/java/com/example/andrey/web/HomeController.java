package com.example.andrey.web;

import com.example.andrey.model.binding.UserLoginBindingModel;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(HttpSession httpSession){

        if(httpSession.getAttribute("user") == null){
            return "index";
        }
        return "home";
    }
}

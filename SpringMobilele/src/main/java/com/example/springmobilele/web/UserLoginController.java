package com.example.springmobilele.web;


import com.example.springmobilele.models.binding.UserLoginDto;
import com.example.springmobilele.models.service.UserLoginServiceModel;
import com.example.springmobilele.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserLoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserLoginController.class);

    private final UserService userService;

    public UserLoginController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/users/login")
    public String login(){
        return "auth-login";
    }


    @PostMapping("/users/login")
    public String login(UserLoginDto userLoginDto){

        boolean loginSuccessful = userService.login(new UserLoginServiceModel()
                .setUsername(userLoginDto.getUsername())
                .setPassword(userLoginDto.getPassword()));

        LOGGER.info("User tried to login. User with name {} tried to login. Success = {}?",
                userLoginDto.getUsername(),
                loginSuccessful);


        return "redirect:/users/login";
    }
}

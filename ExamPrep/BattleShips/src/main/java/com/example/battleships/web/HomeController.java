package com.example.battleships.web;

import com.example.battleships.model.binding.HomeBindingModel;
import com.example.battleships.model.service.UserServiceModel;
import com.example.battleships.model.view.ShipViewModel;
import com.example.battleships.service.ShipService;
import com.example.battleships.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@Controller
public class HomeController {
    private final ShipService shipService;
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final HttpSession httpSession;

    public HomeController(ShipService shipService, UserService userService, ModelMapper modelMapper, HttpSession httpSession) {
        this.shipService = shipService;
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.httpSession = httpSession;
    }

    @GetMapping("/")
    public String index(Model model) {

        if (httpSession.getAttribute("user") == null) {
            return "index";
        }

        UserServiceModel user =
                modelMapper.map(httpSession.getAttribute("user"), UserServiceModel.class);

        UserServiceModel currentUser = userService.findByUsername(user.getUsername());
        List<ShipViewModel> ships = shipService.findAll();
        model.addAttribute("currentUser", currentUser);

        model.addAttribute("attacker",
                ships.stream().filter(e -> e.getUser().getId().equals(currentUser.getId())).collect(Collectors.toList()));
        model.addAttribute("defender",
                ships.stream().filter(e -> !e.getUser().getId().equals(currentUser.getId())).collect(Collectors.toList()));

        model.addAttribute("allShips",ships );

        return "home";
    }

    @PostMapping("/home")
    public String fight(@Valid HomeBindingModel homeBindingModel,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes){

        if (httpSession.getAttribute("user") == null) {
            return "redirect:/";
        }

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("homeBindingModel", homeBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.homeBindingModel", bindingResult);

            return "redirect:/";
        }

        shipService.fight(homeBindingModel);

        return "redirect:/";
    }


    @ModelAttribute
    public HomeBindingModel homeBindingModel(){
        return new HomeBindingModel();
    }
}

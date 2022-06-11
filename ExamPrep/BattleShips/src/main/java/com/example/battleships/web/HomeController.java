package com.example.battleships.web;

import com.example.battleships.model.binding.HomeBindingModel;
import com.example.battleships.model.service.UserServiceModel;
import com.example.battleships.model.view.ShipViewModel;
import com.example.battleships.service.ShipService;
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
    private final ModelMapper modelMapper;

    public HomeController(ShipService shipService, ModelMapper modelMapper) {
        this.shipService = shipService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/")
    public String index(Model model, HttpSession httpSession) {

        if (httpSession.getAttribute("user") == null) {
            return "index";
        }

        UserServiceModel currentUser = modelMapper.map(httpSession.getAttribute("user"), UserServiceModel.class);
        List<ShipViewModel> ships = shipService.findAll();
        model.addAttribute("currentUser", currentUser);

        model.addAttribute("attacker",
                ships.stream().filter(e -> e.getUser().getId().equals(currentUser.getId())).collect(Collectors.toList()));
        model.addAttribute("defender",
                ships.stream().filter(e -> !e.getUser().getId().equals(currentUser.getId())).collect(Collectors.toList()));

        model.addAttribute("allShips",ships );

        return "home";
    }

    @PostMapping("/fire")
    public String fight(@Valid HomeBindingModel homeBindingModel,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("homeBindingModel", homeBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.homeBindingModel", bindingResult);

            return "redirect:/home";
        }

        shipService.fight(homeBindingModel);

        return "redirect:/home";
    }


    @ModelAttribute
    public HomeBindingModel homeBindingModel(){
        return new HomeBindingModel();
    }
}

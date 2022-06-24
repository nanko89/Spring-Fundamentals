package com.example.battleships.web;

import com.example.battleships.model.binding.HomeFireBindingModel;
import com.example.battleships.model.service.UserServiceModel;
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

@Controller
public class HomeController {

    private final ShipService shipService;
    private final HttpSession httpSession;

    private final ModelMapper modelMapper;

    public HomeController(ShipService shipService, HttpSession httpSession, ModelMapper modelMapper) {
        this.shipService = shipService;
        this.httpSession = httpSession;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/")
    public String home(Model model) {
        if (httpSession.getAttribute("user") == null) {
            return "index";
        }
        UserServiceModel user = modelMapper
                .map(httpSession.getAttribute("user"), UserServiceModel.class);

        model.addAttribute( "attacker", shipService.attackerShips(user));
        model.addAttribute( "defender", shipService.defenderShips(user));
        model.addAttribute( "ships", shipService.allShips());

        return "home";
    }

    @PostMapping("/")
    public String fire(@Valid HomeFireBindingModel homeFireBindingModel,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes
                    .addFlashAttribute("homeFireBindingModel", homeFireBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.homeFireBindingModel", bindingResult);
            return "redirect:/";
        }

        shipService.fight(homeFireBindingModel);

        return "redirect:/";
    }

    @ModelAttribute
    public HomeFireBindingModel homeFireBindingModel(){
        return new HomeFireBindingModel();
    }
}

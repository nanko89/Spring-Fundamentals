package com.example.heroes.web;

import com.example.heroes.model.binding.HeroCreateBindingModel;
import com.example.heroes.model.service.HeroServiceModel;
import com.example.heroes.model.view.HeroInfoView;
import com.example.heroes.service.HeroService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/heroes")
public class HeroController {

    private final HeroService heroService;
    private final ModelMapper modelMapper;

    public HeroController(HeroService heroService, ModelMapper modelMapper) {
        this.heroService = heroService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/create")
    public String create(){
        return "create-hero";
    }

    @PostMapping("/create")
    public String confirmCreate(@Valid HeroCreateBindingModel heroCreateBindingModel,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes
                    .addFlashAttribute("heroCreateBindingModel", heroCreateBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.heroCreateBindingModel",
                            bindingResult);

            return "redirect:create";
        }

        heroService.createHero(modelMapper
                .map(heroCreateBindingModel, HeroServiceModel.class));

        return "redirect:/";
    }

    @GetMapping("/details/{id}")
    public String detailsHero(@PathVariable Long id, Model model){
        HeroInfoView hero = heroService.findHeroById(id);

        model.addAttribute("hero", hero);
        return "details-hero";
    }


    @GetMapping("/delete/{id}")
    public String deleteHero(@PathVariable Long id, Model model){

        HeroInfoView hero = heroService.findHeroById(id);

        model.addAttribute("hero", hero);

        return "delete-hero";
    }

    @GetMapping ("/deleted/{id}")
    public String deleteConfirm(@PathVariable Long id){
        heroService.deleteHero(id);
        return "redirect:/";
    }

    @ModelAttribute
    public HeroCreateBindingModel heroCreateBindingModel(){
        return new HeroCreateBindingModel();
    }
}

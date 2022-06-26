package com.example.finalexam.web;

import com.example.finalexam.model.binding.SongAddBindingModel;
import com.example.finalexam.model.entity.Song;
import com.example.finalexam.model.entity.User;
import com.example.finalexam.model.service.SongServiceModel;
import com.example.finalexam.model.service.UserServiceModel;
import com.example.finalexam.service.SongService;
import com.example.finalexam.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/songs")
public class SongController {
    private final SongService songService;
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final HttpSession httpSession;

    public SongController(SongService songService, UserService userService, ModelMapper modelMapper, HttpSession httpSession) {
        this.songService = songService;
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.httpSession = httpSession;
    }


    @GetMapping("/add")
    public String addSong() {
        if (httpSession.getAttribute("user") == null){
            return "redirect:/";
        }


            return "song-add";
    }

    @PostMapping("/add")
    public String confirmSong(@Valid SongAddBindingModel songAddBindingModel,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()){
            redirectAttributes
                    .addFlashAttribute("songAddBindingModel", songAddBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.songAddBindingModel",
                            bindingResult);

            return "redirect:add";
        }

        UserServiceModel user = modelMapper
                .map(httpSession.getAttribute("user"), UserServiceModel.class);

        this.songService
                .addSong(modelMapper
                        .map(songAddBindingModel, SongServiceModel.class), user);

        return "redirect:/";
    }

    @GetMapping("/add/{id}")
    public String addCurrentSong(@PathVariable Long id){

        UserServiceModel serviceModel = modelMapper
                .map(httpSession.getAttribute("user"), UserServiceModel.class);

        Song song = this.songService.findById(id);

        userService.addSong(song, serviceModel);
        return "redirect:/";
    }

    @ModelAttribute
    public SongAddBindingModel songAddBindingModel(){
        return new SongAddBindingModel();
    }
}

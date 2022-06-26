package com.example.finalexam.web;

import com.example.finalexam.model.entity.enums.StyleName;
import com.example.finalexam.model.service.UserServiceModel;
import com.example.finalexam.model.view.HomeAddSongModel;
import com.example.finalexam.service.SongService;
import com.example.finalexam.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    private final UserService userService;
    private final SongService songService;
    private final HttpSession httpSession;
    private final ModelMapper modelMapper;

    public HomeController(UserService userService, SongService songService, HttpSession httpSession, ModelMapper modelMapper) {
        this.userService = userService;
        this.songService = songService;
        this.httpSession = httpSession;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/")
    public String home(Model model) {
        if (httpSession.getAttribute("user") == null) {
            return "index";
        }
        UserServiceModel user = modelMapper.map(httpSession.getAttribute("user"), UserServiceModel.class);

        model.addAttribute("currentUser", this.userService.findByUsername(user.getUsername()));
        model.addAttribute("popSongs", this.songService.findByStyleName(StyleName.POP));
        model.addAttribute("jazzSongs", this.songService.findByStyleName(StyleName.JAZZ));
        model.addAttribute("rockSongs", this.songService.findByStyleName(StyleName.ROCK));
        model.addAttribute("playlist", this.userService.getPlaylist(user));
        model.addAttribute("addSong", new HomeAddSongModel());
        model.addAttribute("totalTime", this.userService.getTotalTime(user));

        return "home";
    }


}

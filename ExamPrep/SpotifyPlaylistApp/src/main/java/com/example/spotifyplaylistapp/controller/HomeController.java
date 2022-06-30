package com.example.spotifyplaylistapp.controller;

import com.example.spotifyplaylistapp.model.entity.enums.StyleName;
import com.example.spotifyplaylistapp.service.SongService;
import com.example.spotifyplaylistapp.service.UserService;
import com.example.spotifyplaylistapp.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final UserService userService;
    private final SongService songService;
    private final CurrentUser currentUser;

    public HomeController(UserService userService, SongService songService, CurrentUser currentUser) {
        this.userService = userService;
        this.songService = songService;
        this.currentUser = currentUser;
    }

    @GetMapping("/")
    public String home(Model model) {
        if (!currentUser.isLogged()) {
            return "index";
        }

        model.addAttribute("totalTime", userService.findTotalTimeToPlaylist());
        model.addAttribute("playlist", songService.getPlaylist());
        model.addAttribute("popSongs", songService.findBySongStyle(StyleName.POP));
        model.addAttribute("rockSongs", songService.findBySongStyle(StyleName.ROCK));
        model.addAttribute("jazzSongs", songService.findBySongStyle(StyleName.JAZZ));
        return "home";
    }
}

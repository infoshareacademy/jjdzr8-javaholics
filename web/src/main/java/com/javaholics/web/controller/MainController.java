package com.javaholics.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String getMain() {
        return "index";
    }

    @GetMapping("/about")
    public String getAbout() {
        return "about";
    }

    @GetMapping("/team")
    public String getTeam() {
        return "team";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

}

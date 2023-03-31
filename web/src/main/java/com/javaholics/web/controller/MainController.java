package com.javaholics.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/public")
public class MainController {

    @GetMapping("/")
    public String getMain() {
        return "index";
    }

    @GetMapping("/about")
    public String getAbout() {
        return "other/about";
    }

    @GetMapping("/team")
    public String getTeam() {
        return "other/team";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "users/login";
    }

}

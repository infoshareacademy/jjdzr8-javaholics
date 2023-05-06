package com.javaholics.web.controller;


import com.javaholics.web.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

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
    public String getLoginForm() {
        return "login";
    }

    @RequestMapping("/login-error.html")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login.html";
    }

//    @GetMapping("/registration")
//    public String getRegistrationForm(WebRequest request, Model model) {
//        UserDto userDto = new UserDto();
//        model.addAttribute("user", userDto);
//        return "users/registration";
}

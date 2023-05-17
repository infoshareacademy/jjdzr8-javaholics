package com.javaholics.web.controller;

import com.javaholics.web.dto.RouteDto;
import com.javaholics.web.dto.UserDto;
import com.javaholics.web.service.RouteService;
import com.javaholics.web.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/public")
public class LogingController {

        private final UserService userService;

        public LogingController(UserService userService) {
        this.userService = userService;
    }

        @GetMapping("/login")
        public String getLoginForm() {
            return "login";
        }

        @RequestMapping("/login-error.html")
        public String loginError(Model model) {
            model.addAttribute("loginError", true);
            return "login";
        }

    @GetMapping("/logout")
    public String getLogoutForm() {
        return "logout";
    }

    @GetMapping("/logoutconfirm")
    public String getLogoutConfirm() {
        return "logoutconfirm";
    }

    @PostMapping("/register")
    public String createUser(@Valid @ModelAttribute UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.addUser(userDto);
        return "redirect:/user/api";
    }

//    @GetMapping("/registration")
//    public String getRegistrationForm(WebRequest request, Model model) {
//        UserDto userDto = new UserDto();
//        model.addAttribute("user", userDto);
//        return "users/registration";


}

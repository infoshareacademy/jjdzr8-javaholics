package com.javaholics.web.controller;

import com.javaholics.web.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/successlogin")
    public String getLoginSuccessWindow() {
        return "login-success";
    }

    @GetMapping("/logout")
    public String getLogoutForm() {
        return "logout";
    }

    @GetMapping("/logoutconfirm")
    public String getLogoutConfirm() {
        return "logoutconfirm";
    }


//    @GetMapping("/registration")
//    public String getRegistrationForm(WebRequest request, Model model) {
//        UserDto userDto = new UserDto();
//        model.addAttribute("user", userDto);
//        return "users/registration";


}

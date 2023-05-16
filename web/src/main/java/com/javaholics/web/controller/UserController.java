package com.javaholics.web.controller;

import com.javaholics.web.dto.UserDto;
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
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/user/create")
    public String addUser(Model model) {
        model.addAttribute("user", new UserDto());
        return "users/adduser";
    }

    @PostMapping("/user")
    public String createUser(@Valid @ModelAttribute UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users/adduser";
        }
        userService.addUser(userDto);
        return "redirect:/public/routes";
    }

    @GetMapping("/user/create-success")
    public String successCreateUser() {
        return "users/create-success";
    }
}

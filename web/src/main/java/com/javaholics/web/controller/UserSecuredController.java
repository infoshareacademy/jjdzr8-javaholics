package com.javaholics.web.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/api")
public class UserSecuredController {

    @GetMapping
    public String helloUser(){
        return "Hello user of Meet2gether";
    }

    @GetMapping("/logged")
    public String loggedUserDetails(){

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String username;

        if (principal instanceof UserDetails) {
            return  username = ((UserDetails)principal).getUsername();
        } else {
            return  username = principal.toString();
        }

    }


}

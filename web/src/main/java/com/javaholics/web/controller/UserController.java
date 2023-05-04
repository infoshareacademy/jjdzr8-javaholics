package com.javaholics.web.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/api")
public class UserController {

    @GetMapping
    public String helloUser(){
        return "Hello user of Meet2gether";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping(value = "/admin")
    public String helloAdminSecuredContr(){
        return "Hello admin of Meet2gether, this is secured controller for your eyes only";
    }

}

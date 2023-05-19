package com.javaholics.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/api")
public class AdminController {

    //    @Secured("ROLE_ADMIN")
    @GetMapping
    public String helloAdminSecuredContr(){
        return "Hello admin of Meet2gether, this is secured controller for your eyes only";
    }
}

package com.javaholics.web.controller;

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


}

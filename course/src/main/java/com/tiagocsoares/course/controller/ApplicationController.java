package com.tiagocsoares.course.controller;

import com.tiagocsoares.course.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    private final UserService service;


    public ApplicationController(UserService service) {
        this.service = service;
    }


    public UserService getService() {
        return service;
    }

    @GetMapping("/")
    public String getHome() {
        return "home";
    }
}

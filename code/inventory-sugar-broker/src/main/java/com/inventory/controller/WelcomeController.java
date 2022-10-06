package com.inventory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    public WelcomeController() {
        System.out.println("Welcome Controller Created");
    }

    @GetMapping("/")
    public String redirectToLogin() {
        System.out.println("Welcome Controller to login page");
        return "user-login";
    }

    @GetMapping("/home")
    public String redirectToIndex() {
        return "index";
    }

}

package com.java.ponomarenko.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String homePage() {
        return "redirect:/user/new";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}

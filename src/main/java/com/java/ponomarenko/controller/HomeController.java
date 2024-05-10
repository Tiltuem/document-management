package com.java.ponomarenko.controller;

import com.java.ponomarenko.service.impl.DefaultEmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final DefaultEmailService emailService;
    @GetMapping("/")
    public String homePage() {
        emailService.sendSimpleEmail("osagrigoriy@mail.ru", "test", "test");
        return "redirect:/user/new";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}

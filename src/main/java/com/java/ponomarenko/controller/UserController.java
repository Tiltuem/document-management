package com.java.ponomarenko.controller;

import com.java.ponomarenko.model.Document;
import com.java.ponomarenko.model.InnerType;
import com.java.ponomarenko.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;


@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/new")
    public String newDocument(@RequestParam(required = false) Boolean added, Model model) {
        model.addAttribute("document", new Document());
        model.addAttribute("types", InnerType.values());
        if (Objects.nonNull(added)) {
            model.addAttribute("added", true);
        } else {
            model.addAttribute("added", false);
        }
        return "add";
    }

    @PostMapping("/add")
    public String saveDocument(Document document, @RequestParam("fileDoc") MultipartFile fileDoc, @RequestParam("endDocument") String endDocument, @RequestParam("typeDocument") String typeDocument) {
        userService.saveDocument(document, fileDoc, endDocument, typeDocument);

        return "redirect:/user/new?added=true";
    }
}

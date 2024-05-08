package com.java.ponomarenko.controller;

import com.java.ponomarenko.model.Document;
import com.java.ponomarenko.model.InnerType;
import com.java.ponomarenko.service.DocumentService;
import com.java.ponomarenko.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequiredArgsConstructor
@RequestMapping("/document")
public class UserController {
    private final UserService userService;

    @GetMapping("/new")
    public String newDocument(Model model) {
        model.addAttribute("document", new Document());
        model.addAttribute("types", InnerType.values());
        return "add";
    }

    @PostMapping("/add")
    public String saveDocument(Document document, @RequestParam("fileDoc") MultipartFile fileDoc, @RequestParam("endDocument") String endDocument, @RequestParam("typeDocument") String typeDocument) {
        userService.saveDocument(document, fileDoc, endDocument, typeDocument);

        return "redirect:/";
    }
}

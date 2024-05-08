package com.java.ponomarenko.controller;

import com.java.ponomarenko.model.Document;
import com.java.ponomarenko.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping( "/document")
public class UserController {
    private final DocumentService documentService;

    @PostMapping("/add")
    public void saveDocument(@RequestBody Document document) {
        documentService.saveDocument(document);
    }
}

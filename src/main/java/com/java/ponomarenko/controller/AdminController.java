package com.java.ponomarenko.controller;


import com.java.ponomarenko.model.Document;
import com.java.ponomarenko.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/v1/admin")
public class AdminController {
    private final DocumentService documentService;
    private static final int SIZE_PAGE = 10;

    @GetMapping("/documents/{page}")
    public String getAllByCity(@PathVariable int page, Model model) {
        String city = "test";
        Page<Document> documents = documentService.getAllByCity(PageRequest.of(page, SIZE_PAGE, Sort.by("id")), city);
        model.addAttribute("documentList", documents);

        return "add";
    }


}

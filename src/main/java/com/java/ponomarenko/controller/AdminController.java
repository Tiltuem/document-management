package com.java.ponomarenko.controller;


import com.java.ponomarenko.model.Document;
import com.java.ponomarenko.model.DocumentType;
import com.java.ponomarenko.model.InnerType;
import com.java.ponomarenko.service.AdminService;
import com.java.ponomarenko.service.impl.DefaultEmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;


@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;
    private final DefaultEmailService defaultEmailService;

    @GetMapping("/documents/{page}")
    public String getAllByCity(@PathVariable int page, Model model) {
        return adminService.getAllByCity(page, model);
    }

    @PostMapping("/document/upload")
    public String uploadFile(
            @RequestPart("fileDoc") MultipartFile fileDoc,
            @RequestPart("fileName") String fileName) {
        adminService.updateDocument(fileDoc, fileName);
        defaultEmailService.sendSimpleEmail("ezzystrike@gmail.com", "ЧТО-ТО", "ТЕСТЕСТЕСТ");
        return "redirect:/admin/documents/0";
    }

    @GetMapping("/documents/{page}-search")
    public String searchEntries(@RequestParam(required = false) String username,
                                @RequestParam(required = false) String dateFrom,
                                @RequestParam(required = false) String dateBy,
                                @RequestParam(required = false) String columnDate,
                                @RequestParam(required = false) String type,
                                @RequestParam(required = false) String name,
                                @RequestParam(required = false) String innerType,
                                @RequestParam(required = false) String city,
                                @PathVariable int page,
                                Model model) {

        return adminService.searchDocuments(username, dateFrom, dateBy, columnDate, type, name, innerType, city, model, page);
    }

    @GetMapping("/new")
    public String newDocument(@RequestParam(required = false) Boolean added, Model model) {
        model.addAttribute("document", new Document());
        model.addAttribute("types", DocumentType.INTERNAL.getInnerType());
        if (Objects.nonNull(added)) {
            model.addAttribute("added", true);
        } else {
            model.addAttribute("added", false);
        }

        return "addDocumentDir";
    }

    @PostMapping("/add")
    public String saveDocument(Document document, @RequestParam("fileDoc") MultipartFile fileDoc, @RequestParam("startDocument") String startDocument, @RequestParam("innerType") String innerType) {
        adminService.saveDocument(document, fileDoc, startDocument, innerType);

        return "redirect:/admin/new?added=true";
    }
}

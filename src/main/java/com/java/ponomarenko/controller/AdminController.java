package com.java.ponomarenko.controller;


import com.java.ponomarenko.model.Document;
import com.java.ponomarenko.model.InnerType;
import com.java.ponomarenko.service.AdminService;
import com.java.ponomarenko.service.impl.DefaultEmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static com.java.ponomarenko.util.UserUtil.getCity;

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
    public String searchEntries(@RequestParam(required = false) String name,
                                @RequestParam(required = false) String dateFrom,
                                @RequestParam(required = false) String dateBy,
                                @RequestParam(required = false) String columnDate,
                                @PathVariable int page,
                                Model model) {

        return adminService.searchDocuments(name, dateFrom, dateBy, columnDate, model, page);
    }

    @GetMapping("/new")
    public String newDocument(Model model) {
        model.addAttribute("document", new Document());
        model.addAttribute("types", InnerType.values());

        return "addDocumentDir";
    }

    @PostMapping("/add")
    public String saveDocument(Document document, @RequestParam("fileDoc") MultipartFile fileDoc, @RequestParam("endDocument") String endDocument, @RequestParam("typeDocument") String typeDocument) {
        adminService.saveDocument(document, fileDoc, endDocument, typeDocument);

        return "redirect:/admin/documents/0";
    }
}

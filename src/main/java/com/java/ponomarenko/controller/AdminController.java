package com.java.ponomarenko.controller;


import com.java.ponomarenko.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;


    @GetMapping("/documents/{page}")
    public String getAllByCity(@PathVariable int page, Model model) {
        return adminService.getAllByCity(page, model);
    }

    @PostMapping("/document/upload")
    public String uploadFile(
            @RequestPart("fileDoc") MultipartFile fileDoc,
            @RequestPart("fileName") String fileName) {
        adminService.updateDocument(fileDoc, fileName);

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
}

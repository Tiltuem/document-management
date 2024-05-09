package com.java.ponomarenko.service.impl;

import com.java.ponomarenko.model.Document;
import com.java.ponomarenko.service.AdminService;
import com.java.ponomarenko.service.DocumentService;
import com.java.ponomarenko.service.MinioService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final Map<String, String> usernameHisCity = Map.of("dirSamara", "Самара", "dirMoscow", "Москва", "dirStPeter", "Санкт-Петербург", "admin", "all");
    private static final int SIZE_PAGE = 10;
    private final DocumentService documentService;
    private final MinioService minioService;


    @Override
    public String getAllByCity(int page, Model model) {
        String city =
                usernameHisCity.get(SecurityContextHolder.getContext().getAuthentication().getName());
        Page<Document> documents = city.equals("all") ?
                documentService.getAll(PageRequest.of(page, SIZE_PAGE, Sort.by("id"))) :
                documentService.getAllByCity(PageRequest.of(page, SIZE_PAGE, Sort.by("id")), city);
        changeTemporaryLink(documents);
        model.addAttribute("documents", documents);
        model.addAttribute("itsAdmin", city.equals("all"));

        return "documentsByCity";
    }

    @Override
    public void updateDocument(MultipartFile fileDoc, String fileName) {
        minioService.saveFile(fileDoc, fileName);
    }

    private void changeTemporaryLink(Page<Document> documents) {
        documents.getContent()
                .forEach(document -> document.setTemporaryLink(minioService.getFileUrl(document.getFile())));
    }
}

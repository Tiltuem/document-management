package com.java.ponomarenko.service;


import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

public interface AdminService {
    String getAllByCity(int page, Model model);

    void updateDocument(MultipartFile fileDoc, String fileName);

    String searchDocuments(String name, String dateFrom, String dateBy, String columnDate, Model model, int page);
}

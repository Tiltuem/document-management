package com.java.ponomarenko.service;


import com.java.ponomarenko.model.Document;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

public interface AdminService {
    String getAllByCity(int page, Model model);

    void updateDocument(MultipartFile fileDoc, String fileName);

    void deleteDocument(long id);

    void saveDocument(Document document, MultipartFile fileDoc, String startDocument, String innerType);

    String searchDocuments(String username, String dateFrom, String dateBy, String columnDate, String type, String name, String innerType, String city, Model model, int page);
}

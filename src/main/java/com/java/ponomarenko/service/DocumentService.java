package com.java.ponomarenko.service;


import com.java.ponomarenko.model.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface DocumentService {
    Page<Document> getAllByCity(Pageable pageable, String city);
    Page<Document> getAll(Pageable pageable);

    void saveDocument(Document document, MultipartFile fileDoc, String fileName, String city);

    void deleteDocument(long id);
}

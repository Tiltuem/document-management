package com.java.ponomarenko.service;


import com.java.ponomarenko.model.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DocumentService {
    Page<Document> getAllByCity(Pageable pageable, String city);
    Page<Document> getAll(Pageable pageable);

    void saveDocument(Document document);
}

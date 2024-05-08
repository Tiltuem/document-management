package com.java.ponomarenko.service;


import com.java.ponomarenko.model.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DocumentService {
    void saveDocument(Document document);

    Page<Document> getAllByCity(Pageable pageable, String city);
}

package com.java.ponomarenko.service;

import com.java.ponomarenko.model.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {
    Page<Document> getAllByCity(Pageable pageable, String city);

    void saveDocument(Document document, MultipartFile fileDoc, String endDocument, String typeDocument);
}

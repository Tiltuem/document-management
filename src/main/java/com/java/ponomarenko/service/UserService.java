package com.java.ponomarenko.service;

import com.java.ponomarenko.model.Document;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {
    void saveDocument(Document document, MultipartFile fileDoc, String endDocument, String typeDocument, String city, String email);
}

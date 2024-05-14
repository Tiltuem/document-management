package com.java.ponomarenko.service.impl;

import com.java.ponomarenko.model.Document;
import com.java.ponomarenko.model.DocumentType;
import com.java.ponomarenko.service.DocumentService;
import com.java.ponomarenko.service.MinioService;
import com.java.ponomarenko.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private static final String FILE_NAME = "%s/%s";
    private final DocumentService documentService;

    @Override
    public void saveDocument(Document document, MultipartFile fileDoc, String endDocument, String typeDocument, String city, String email) {
        DocumentType documentType = DocumentType.EXTERNAL;
        String fileName = String.format(FILE_NAME, documentType, fileDoc.getOriginalFilename());

        document.setEndDate(LocalDate.parse(endDocument));
        document.setType(documentType);
        document.setPassportType(typeDocument);
        document.setEmail(email);

        documentService.saveDocument(document, fileDoc, fileName, city);
    }
}

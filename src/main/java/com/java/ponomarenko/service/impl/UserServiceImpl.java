package com.java.ponomarenko.service.impl;

import com.java.ponomarenko.model.Document;
import com.java.ponomarenko.model.DocumentType;
import com.java.ponomarenko.model.InnerType;
import com.java.ponomarenko.service.DocumentService;
import com.java.ponomarenko.service.MinioService;
import com.java.ponomarenko.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private static final String FILE_NAME = "%s/%s/%s";
    private final DocumentService documentService;
    private final MinioService minioService;

    @Override
    public void saveDocument(Document document, MultipartFile fileDoc, String endDocument, String typeDocument) {
        DocumentType documentType = DocumentType.EXTERNAL.getInnerType().contains(InnerType.valueOf(typeDocument)) ? DocumentType.EXTERNAL : DocumentType.INTERNAL;
        String fileName = String.format(FILE_NAME, documentType, typeDocument, fileDoc.getOriginalFilename());

        document.setEndDate(Date.valueOf(endDocument));
        document.setFile(fileName);
        document.setType(documentType);

        minioService.saveImage(fileDoc, fileName);
        documentService.saveDocument(document);
    }
}

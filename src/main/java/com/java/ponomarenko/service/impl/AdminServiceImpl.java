package com.java.ponomarenko.service.impl;

import com.java.ponomarenko.model.Document;
import com.java.ponomarenko.service.AdminService;
import com.java.ponomarenko.service.DocumentService;
import com.java.ponomarenko.service.MinioService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final DocumentService documentService;
    private final MinioService minioService;


    @Override
    public Page<Document> getAllByCity(Pageable pageable, String city) {
        Page<Document> documents = documentService.getAllByCity(pageable, city);
        changeTemporaryLink(documents);

        return documents;
    }

    private void changeTemporaryLink(Page<Document> documents) {
        documents.getContent()
                .forEach(document -> document.setTemporaryLink(minioService.getImagesUrl(document.getFile())));
    }
}

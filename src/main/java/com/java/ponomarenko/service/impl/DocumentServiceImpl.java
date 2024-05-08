package com.java.ponomarenko.service.impl;

import com.java.ponomarenko.model.Document;
import com.java.ponomarenko.repository.DocumentRepository;
import com.java.ponomarenko.service.DocumentService;
import com.java.ponomarenko.service.MinioService;
import com.java.ponomarenko.service.impl.MinioServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService {
    private final DocumentRepository repository;

    @Override
    public void saveDocument(Document document) {
        repository.save(document);
    }

    @Override
    public Page<Document> getAllByCity(Pageable pageable, String city) {
        return repository.findAllByCity(pageable, city);
    }
}

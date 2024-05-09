package com.java.ponomarenko.service.impl;

import com.java.ponomarenko.model.Document;
import com.java.ponomarenko.repository.DocumentRepository;
import com.java.ponomarenko.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


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

    @Override
    public Page<Document> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}

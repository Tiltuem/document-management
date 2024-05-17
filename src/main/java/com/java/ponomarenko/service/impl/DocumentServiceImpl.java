package com.java.ponomarenko.service.impl;

import com.java.ponomarenko.model.Document;
import com.java.ponomarenko.repository.DocumentRepository;
import com.java.ponomarenko.service.DocumentService;
import com.java.ponomarenko.service.MinioService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService {
    private final DocumentRepository repository;
    private final MinioService minioService;

    @Override
    public void saveDocument(Document document, MultipartFile fileDoc, String fileName, String city) {
        document.setFile(fileName);
        document.setCity(city);

        minioService.saveFile(fileDoc, fileName);
        repository.save(document);
    }

    @Override
    public void deleteDocument(long id) {
        repository.deleteById(id);
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

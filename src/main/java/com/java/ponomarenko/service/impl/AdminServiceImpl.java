package com.java.ponomarenko.service.impl;

import com.java.ponomarenko.model.Document;
import com.java.ponomarenko.service.AdminService;
import com.java.ponomarenko.service.DocumentService;
import com.java.ponomarenko.service.MinioService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;


import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final Map<String, String> usernameHisCity = Map.of("dirSamara", "Самара", "dirMoscow", "Москва", "dirStPeter", "Санкт-Петербург", "admin", "all");
    private static final int SIZE_PAGE = 1;
    private final DocumentService documentService;
    private final MinioService minioService;

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public String getAllByCity(int page, Model model) {
        String city =
                usernameHisCity.get(SecurityContextHolder.getContext().getAuthentication().getName());
        Page<Document> documents = city.equals("all") ?
                documentService.getAll(PageRequest.of(page, SIZE_PAGE, Sort.by("id"))) :
                documentService.getAllByCity(PageRequest.of(page, SIZE_PAGE, Sort.by("id")), city);
        setModel(model, documents, false);

        return "documentsByCity";
    }

    @Override
    public void updateDocument(MultipartFile fileDoc, String fileName) {
        minioService.saveFile(fileDoc, fileName);
    }

    @Override
    public String searchDocuments(String name, String dateFrom, String dateBy, String columnDate, Model model, int page) {
        String date = dateBy;
        Page<Document> documents;
        if (dateBy.equals("")) {
            date = LocalDate.now().toString();
        }

        if (!name.equals("") || !dateFrom.equals("")) {
            documents = search(PageRequest.of(page, SIZE_PAGE, Sort.by("id")), name, columnDate, dateFrom, date);
        } else {
            return getAllByCity(page, model);
        }
        setModel(model, documents, true);

        return "documentsByCity";
    }

    private void changeTemporaryLink(Page<Document> documents) {
        documents.getContent()
                .forEach(document -> document.setTemporaryLink(minioService.getFileUrl(document.getFile())));
    }

    private Page<Document> search(Pageable pageable,
                                  String name,
                                  String columnDate,
                                  String dateFrom,
                                  String dateBy) {
        Query query;
        StringBuilder queryString = new StringBuilder("SELECT d FROM Document d WHERE d.");
        String myValue = name;
        if (!name.equals("")) {
            queryString.append("username" + " = ?1");

            if (!dateFrom.equals("")) {
                queryString.append(" AND d." + columnDate + " BETWEEN ?2 AND ?3");
                query = entityManager.createQuery(queryString.toString())
                        .setParameter(1, myValue)
                        .setParameter(2, Date.valueOf(dateFrom))
                        .setParameter(3, Date.valueOf(dateBy));
            } else {
                query = entityManager.createQuery(queryString.toString())
                        .setParameter(1, myValue);
            }
        } else {
            if (!dateFrom.equals("")) {
                queryString.append(columnDate + " BETWEEN ?1 AND ?2");

                query = entityManager.createQuery(queryString.toString())
                        .setParameter(1, Date.valueOf(dateFrom))
                        .setParameter(2, Date.valueOf(dateBy));
            } else {
                query = entityManager.createQuery("SELECT d FROM Document d");

            }
        }

        List entries = query.getResultList();
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), entries.size());
        List<Document> pageContent = entries.subList(start, end);

        return new PageImpl<>(pageContent, pageable, entries.size());
    }

    private void setModel(Model model, Page<Document> documents, boolean search) {
        String city =
                usernameHisCity.get(SecurityContextHolder.getContext().getAuthentication().getName());
        changeTemporaryLink(documents);
        model.addAttribute("documents", documents);
        model.addAttribute("itsAdmin", city.equals("all"));
        model.addAttribute("search", search);
    }
}

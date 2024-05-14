package com.java.ponomarenko.service.impl;

import com.java.ponomarenko.model.Document;
import com.java.ponomarenko.model.DocumentType;
import com.java.ponomarenko.model.InnerType;
import com.java.ponomarenko.service.AdminService;
import com.java.ponomarenko.service.DocumentService;
import com.java.ponomarenko.service.MinioService;
import com.java.ponomarenko.service.UserService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;


import java.sql.Date;

import java.time.LocalDate;
import java.util.List;


import static com.java.ponomarenko.util.UserUtil.getCity;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private static final int SIZE_PAGE = 5;
    private final DocumentService documentService;
    private final MinioService minioService;
    private static final String FILE_NAME = "%s/%s/%s";
    @PersistenceContext
    EntityManager entityManager;


    @Override
    public String getAllByCity(int page, Model model) {
        String city = getCity();
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
        Page<Document> documents;
        if (!name.equals("") || !dateFrom.equals("") || !dateBy.equals("")) {
            documents = search(PageRequest.of(page, SIZE_PAGE, Sort.by("id")), name, columnDate, dateFrom, dateBy);
        } else {
            return getAllByCity(page, model);
        }
        setModel(model, documents, true);

        return "documentsByCity";
    }

    @Override
    public void saveDocument(Document document, MultipartFile fileDoc, String startDocument, String innerType) {
        DocumentType documentType = DocumentType.INTERNAL;
        String fileName = String.format(FILE_NAME, documentType, innerType, fileDoc.getOriginalFilename());

        document.setType(documentType);
        document.setInnerType(InnerType.valueOf(innerType));

        document.setStartDate(LocalDate.parse(startDocument));

        documentService.saveDocument(document, fileDoc, fileName, getCity());
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
            queryString.append("username" + " LIKE ?1 ");

            if (!dateFrom.equals("")) {
                if (dateBy.equals("")) {
                    queryString.append(" AND d." + columnDate + " > ?2)");
                    query = entityManager.createQuery(queryString.toString())
                            .setParameter(1, myValue)
                            .setParameter(2, Date.valueOf(dateFrom));
                } else {
                    queryString.append(" AND d." + columnDate + " BETWEEN ?2 AND ?3");
                    query = entityManager.createQuery(queryString.toString())
                            .setParameter(1, myValue)
                            .setParameter(2, Date.valueOf(dateFrom))
                            .setParameter(3, Date.valueOf(dateBy));
                }
            } else if (!dateBy.equals("")) {
                queryString.append(" AND d." + columnDate + " < ?2");

                query = entityManager.createQuery(queryString.toString())
                        .setParameter(1, myValue)
                        .setParameter(2, Date.valueOf(dateBy));
            }else {
                query = entityManager.createQuery(queryString.toString())
                        .setParameter(1, myValue);
            }
        } else {
            if (!dateFrom.equals("")) {
                if (dateBy.equals("")) {
                    queryString.append(columnDate + " > ?1");

                    query = entityManager.createQuery(queryString.toString())
                            .setParameter(1, Date.valueOf(dateFrom));
                } else {
                    queryString.append(columnDate + " BETWEEN ?1 AND ?2");

                    query = entityManager.createQuery(queryString.toString())
                            .setParameter(1, Date.valueOf(dateFrom))
                            .setParameter(2, Date.valueOf(dateBy));
                }
            } else if (!dateBy.equals("")) {
                queryString.append(columnDate + " < ?1");

                query = entityManager.createQuery(queryString.toString())
                        .setParameter(1, Date.valueOf(dateBy));
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
        String city = getCity();
        changeTemporaryLink(documents);
        model.addAttribute("documents", documents);
        model.addAttribute("itsAdmin", city.equals("all"));
        model.addAttribute("search", search);
    }
}

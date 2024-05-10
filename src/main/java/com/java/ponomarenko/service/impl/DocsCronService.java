package com.java.ponomarenko.service.impl;

import com.java.ponomarenko.model.Document;
import com.java.ponomarenko.repository.DocumentRepository;
import com.java.ponomarenko.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.compress.utils.TimeUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DocsCronService {
    private static final String EVERY_DAY = "0 0 0 * * *";
    private static final String sendTo = "";
    private static final String subjet = "Документ %s через 2 недели будет просрочен!";
    private static final String text = "Документ %s через 2 недели будет просрочен!";

    private final DocumentRepository documentRepository;
    private final DefaultEmailService defaultEmailService;

    @Scheduled(cron = EVERY_DAY)
    public void updOrdersStatus() {
        List<Document> documentList = documentRepository.findAll().stream().filter(this::compareDate).toList();
        documentList.forEach(doc ->
                defaultEmailService.sendSimpleEmail(sendTo,
                        String.format(subjet, doc.getName()),
                        String.format(text, doc.getName())));
    }

    private boolean compareDate(Document document) {
        LocalDate now = LocalDate.now();
        return document.getEndDate().plusWeeks(2).isEqual(now);
    }
}


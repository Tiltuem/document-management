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
    private static final String EVERY_5SEC = "*/5 * * * * *"; //Для проверки
    private static final String SEND_TO = "flypro.documents@gmail.com"; //Вставить почту получателя
    private static final String SUBJECT = "FLY PRODUCTION";
    private static final String TEXT = "Документ %s через 2 недели будет просрочен!";

    private final DocumentRepository documentRepository;
    private final DefaultEmailService defaultEmailService;

    @Scheduled(cron = EVERY_DAY)
    public void updOrdersStatus() {
        List<Document> documentList = documentRepository.findAll().stream().filter(this::compareDate).toList();
        documentList.forEach(doc ->
                defaultEmailService.sendSimpleEmail(SEND_TO,
                        SUBJECT,
                        String.format(TEXT, doc.getName())));
    }

    private boolean compareDate(Document document) {
        LocalDate now = LocalDate.now();
        return document.getEndDate().minusWeeks(2).isEqual(now);
    }
}


package com.java.ponomarenko.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Entity
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String city;
    private String file;
    private String name;
    @Column(columnDefinition = "date")
    @CreatedDate
    private LocalDate createdDate;
    @Enumerated(EnumType.STRING)
    private DocumentType type;
    @Transient
    private String temporaryLink;
    // Юзер
    private String passportType;
    private String passportSeries;
    private String passportNumber;
    private String passportByWhom;
    private String phoneNumber;
    private String email;
    @Column(columnDefinition = "date")
    private LocalDate endDate;
    // Админ
    @Column(columnDefinition = "date")
    private LocalDate startDate;
    private String comment;
    @Enumerated(EnumType.STRING)
    private InnerType innerType;

}

package com.java.ponomarenko.service.impl;

import com.java.ponomarenko.model.Document;
import com.java.ponomarenko.model.DocumentType;
import com.java.ponomarenko.model.InnerType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DocumentSpecification {
    public Specification<Document> build(String name, String dateFrom, String dateBy, String columnDate) {
        return withUsernameLike(name)
                .and(withDateAtGt(columnDate, dateFrom))
                .and(withDateAtLs(columnDate, dateBy))
                //.and(withType(type))
                //.and(withInnerType(innerType))
                ;
    }

    private Specification<Document> withUsernameLike(String name) {
        return (root, query, cb) -> name.isEmpty() ? cb.conjunction() : cb.like(root.get("username"), "%" + name + "%");
    }

    private Specification<Document> withDateAtGt(String columnName, String date) {
        return (root, query, cb) -> date.isEmpty() ? cb.conjunction() : cb.greaterThanOrEqualTo(root.get(columnName), LocalDate.parse(date));
    }

    private Specification<Document> withDateAtLs(String columnName, String date) {
        return (root, query, cb) -> date.isEmpty() ? cb.conjunction() : cb.lessThanOrEqualTo(root.get(columnName), LocalDate.parse(date));
    }

    private Specification<Document> withType(DocumentType type) {
        return (root, query, cb) -> type == null ? cb.conjunction() : cb.equal(root.get("type"), type);
    }

    private Specification<Document> withInnerType(InnerType type) {
        return (root, query, cb) -> type == null ? cb.conjunction() : cb.equal(root.get("innerType"), type);
    }
}

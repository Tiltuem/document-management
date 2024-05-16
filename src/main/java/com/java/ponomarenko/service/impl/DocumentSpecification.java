package com.java.ponomarenko.service.impl;

import com.java.ponomarenko.model.Document;
import com.java.ponomarenko.model.DocumentType;
import com.java.ponomarenko.model.InnerType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.time.LocalDate;

@Component
public class DocumentSpecification {
    public Specification<Document> build(String username, String dateFrom, String dateBy, String columnDate, String type, String name, String innerType) {
        return withUsernameLike(username)
                .and(withDateAtGt(columnDate, dateFrom))
                .and(withDateAtLs(columnDate, dateBy))
                .and(withType(type))
                .and(withInnerType(innerType))
                .and(withName(name));
    }

    private Specification<Document> withUsernameLike(String name) {
        return (root, query, cb) -> name.equals("") ? cb.conjunction() : cb.like(root.get("username"), "%" + name + "%");
    }

    private Specification<Document> withDateAtGt(String columnName, String date) {
        return (root, query, cb) -> date.equals("") ? cb.conjunction() : cb.greaterThanOrEqualTo(root.get(columnName), LocalDate.parse(date));
    }

    private Specification<Document> withDateAtLs(String columnName, String date) {
        return (root, query, cb) -> date.equals("") ? cb.conjunction() : cb.lessThanOrEqualTo(root.get(columnName), LocalDate.parse(date));
    }

    private Specification<Document> withType(String type) {
        return (root, query, cb) -> type.equals("") ? cb.conjunction() : cb.equal(root.get("type"), DocumentType.getType(type));
    }

    private Specification<Document> withInnerType(String innerType) {
        return (root, query, cb) -> innerType.equals("") ? cb.conjunction() : cb.equal(root.get("innerType"), InnerType.getType(innerType));
    }

    private Specification<Document> withName(String name) {
        return (root, query, cb) -> name.equals("") ? cb.conjunction() : cb.equal(root.get("name"), name);
    }
}

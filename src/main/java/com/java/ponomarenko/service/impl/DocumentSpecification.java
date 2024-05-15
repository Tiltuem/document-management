package com.java.ponomarenko.service.impl;

import com.java.ponomarenko.model.Document;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DocumentSpecification {
    public Specification<Document> build(String name, String dateFrom, String dateBy, String columnDate) {
        return withUsernameLike(name)
                .and(withDateAtGt(columnDate, LocalDate.parse(dateFrom)))
                .and(withDateAtLs(columnDate, LocalDate.parse(dateBy)));
    }

    private Specification<Document> withUsernameLike(String name) {
        return (root, query, cb) -> name == null ? cb.conjunction() : cb.like(root.get("name"), name);
    }

    private Specification<Document> withDateAtGt(String columnName, LocalDate date) {
        return (root, query, cb) -> date == null ? cb.conjunction() : cb.greaterThanOrEqualTo(root.get(columnName), date);
    }

    private Specification<Document> withDateAtLs(String columnName, LocalDate date) {
        return (root, query, cb) -> date == null ? cb.conjunction() : cb.lessThanOrEqualTo(root.get(columnName), date);
    }
}

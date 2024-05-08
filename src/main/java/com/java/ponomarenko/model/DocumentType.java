package com.java.ponomarenko.model;

import lombok.AllArgsConstructor;

import lombok.Getter;

import java.util.List;

import static com.java.ponomarenko.model.InnerType.*;


@AllArgsConstructor
@Getter
public enum DocumentType {
    INTERNAL(List.of(CHECKS,
            WRITTEN_AGREEMENTS,
            CONTRACTS_CUSTOMERS,
            AGENCY_AGREEMENTS)),

    EXTERNAL(List.of(TABLE_BY_CITY,
            TABLE_BY_AGE,
            TABLE_BY_END_DATE,
            REPORTS));

    private final List<InnerType> innerType;
}

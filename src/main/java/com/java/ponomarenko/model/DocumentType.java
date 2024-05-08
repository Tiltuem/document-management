package com.java.ponomarenko.model;

import lombok.AllArgsConstructor;

import lombok.Getter;


@AllArgsConstructor
@Getter
public enum DocumentType {
    INTERNAL(),
    EXTERNAL();

    private final String innerType;
}

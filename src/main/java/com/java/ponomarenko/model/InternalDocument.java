package com.java.ponomarenko.model;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class InternalDocument extends Document {
    @ManyToOne
    private ExternalDocumentType documentType;
}

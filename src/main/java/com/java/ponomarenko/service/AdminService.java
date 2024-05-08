package com.java.ponomarenko.service;

import com.java.ponomarenko.model.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AdminService {
    Page<Document> getAllByCity(Pageable pageable, String city);

}

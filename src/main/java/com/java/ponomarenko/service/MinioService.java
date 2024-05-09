package com.java.ponomarenko.service;

import org.springframework.web.multipart.MultipartFile;

public interface MinioService {
    void saveFile(MultipartFile file, String fileName);

    void deleteFile(String fileName);

    String getFileUrl(String objectName);
}

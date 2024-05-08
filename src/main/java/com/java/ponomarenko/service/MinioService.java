package com.java.ponomarenko.service;

import org.springframework.web.multipart.MultipartFile;

public interface MinioService {
    void saveImage(MultipartFile file, String fileName);

    void deleteImage(String fileName);

    void getImagesUrl(String objectName);
}

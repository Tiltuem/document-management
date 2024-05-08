package com.java.ponomarenko.service.impl;

import com.java.ponomarenko.service.MinioService;
import io.minio.*;
import io.minio.errors.*;
import io.minio.http.Method;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class MinioServiceImpl implements MinioService {
    private final static Integer EXPIRY_IN_SECOND = 7200; // 7200 секунд = 2 часа.
    private final static String bucketName = "docs";

    @Autowired
    private MinioClient minioClient;

    @Override
    public void saveImage(MultipartFile file, String fileName) {
        try {
            Map<String, String> metadata = new HashMap<>();
            metadata.put("originalFilename", file.getOriginalFilename());

            ObjectWriteResponse a = minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(bucketName)
                            .object(fileName)
                            .userMetadata(metadata)
                            .stream(file.getInputStream(), file.getSize(), -1)
                            .contentType(file.getContentType())
                            .build());
        } catch (Exception e) {
            log.error("Сохранение нового изображения не выполнено.");
            throw new RuntimeException("Error occurred during uploading image.");
        }
    }

    @Override
    public void deleteImage(String fileName) {
        try {
            minioClient.removeObject(
                    RemoveObjectArgs.builder()
                            .bucket(bucketName)
                            .object(fileName)
                            .build());
            log.info("Изображение с названием %s удалено успешно.", fileName);
        } catch (Exception e) {
            log.error("Удалить изображение с названием %s не удалось.", fileName);
            throw new RuntimeException("Error occurred during deleting image.");
        }
    }

    @Override
    public void getImagesUrl(String objectName) {
        try {
            minioClient.getPresignedObjectUrl(GetPresignedObjectUrlArgs.builder().method(Method.GET).bucket("docs").object(objectName).expiry(60*60).build());
        } catch (ErrorResponseException | InsufficientDataException | InternalException | InvalidKeyException |
                 InvalidResponseException | IOException | NoSuchAlgorithmException | XmlParserException |
                 ServerException e) {
            throw new RuntimeException(e);
        }

    }
}

package com.java.ponomarenko.controller;

import com.java.ponomarenko.service.MinioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/delivery-service/minio")
@RequiredArgsConstructor
@CrossOrigin
public class MinioController {
    @Autowired
    private MinioService minioService;

    @PostMapping("/upload")
    public void uploadFile(
            @RequestPart("file") MultipartFile file,
            @RequestPart("fileName") String fileName) {
        minioService.saveImage(file, fileName);
    }


    @DeleteMapping("/delete")
    public void deleteFile(@RequestParam("fileName") String fileName) {
        minioService.deleteImage(fileName);
    }
}

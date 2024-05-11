package com.java.ponomarenko.configuration;

import io.minio.MinioClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinioConfig {
    private final String endpoint = "http://minio:9000";
    private final String accessKey = "adminLogin";
    private final String secretKey = "ch3Wuetm";

    @Bean
    public MinioClient minioClient() {
        return MinioClient.builder()
                .endpoint(endpoint)
                .credentials(accessKey, secretKey)
                .build();
    }
}

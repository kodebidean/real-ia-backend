package com.real_ia.backend.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app")
@Getter
@Setter
public class AppProperties {
    private Jwt jwt = new Jwt();
    private Cors cors = new Cors();

    @Getter
    @Setter
    public static class Jwt {
        private String secret;
        private long expirationMs = 86400000; // 24 horas por defecto
    }

    @Getter
    @Setter
    public static class Cors {
        private String[] allowedOrigins = {"http://localhost:3000", "http://localhost:8081"};
        private String[] allowedMethods = {"GET", "POST", "PUT", "DELETE", "OPTIONS"};
        private String[] allowedHeaders = {"Authorization", "Content-Type"};
        private String[] exposedHeaders = {"Authorization"};
    }
} 
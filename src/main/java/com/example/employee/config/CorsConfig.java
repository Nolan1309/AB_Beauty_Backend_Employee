package com.example.employee.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.List;

@Configuration
public class CorsConfig {

    @Value("#{'${allowed.origins}'.split(',')}")
    private List<String> allowedOrigins;

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        boolean hasWildcard = allowedOrigins.contains("*");
        
        if (hasWildcard) {
            config.addAllowedOrigin("*");
        } else {
            config.setAllowedOrigins(allowedOrigins);
            config.setAllowCredentials(true);
        }
        config.addAllowedHeader("*");
        
        // Cho phép tất cả các phương thức HTTP
        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("OPTIONS");
        
        // Cho phép truy cập Authorization header
        config.setExposedHeaders(Arrays.asList("Authorization", "Content-Type"));
        
        // Áp dụng cấu hình CORS cho tất cả các endpoint
        source.registerCorsConfiguration("/**", config);
        
        return new CorsFilter(source);
    }
} 
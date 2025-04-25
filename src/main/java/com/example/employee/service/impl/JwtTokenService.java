package com.example.employee.service.impl;


public interface JwtTokenService {
    String generateToken(String email);
    String extractUsername(String token);
    Boolean validateToken(String token, org.springframework.security.core.userdetails.UserDetails userDetails);
} 
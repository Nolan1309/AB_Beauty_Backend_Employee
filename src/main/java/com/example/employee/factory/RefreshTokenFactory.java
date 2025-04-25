package com.example.employee.factory;

import com.example.employee.model.Employee;
import com.example.employee.model.RefreshToken;

import java.time.Instant;
import java.util.UUID;

public class RefreshTokenFactory {

    public static RefreshToken createRefreshToken(Employee employee, long durationInMs) {
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setEmployee(employee);
        refreshToken.setToken(UUID.randomUUID().toString());
        refreshToken.setExpiryDate(Instant.now().plusMillis(durationInMs));
        refreshToken.setRevoked(false);
        return refreshToken;
    }
   
    public static RefreshToken updateRefreshToken(RefreshToken existingToken, long durationInMs) {
        existingToken.setToken(UUID.randomUUID().toString());
        existingToken.setExpiryDate(Instant.now().plusMillis(durationInMs));
        existingToken.setRevoked(false);
        return existingToken;
    }
} 
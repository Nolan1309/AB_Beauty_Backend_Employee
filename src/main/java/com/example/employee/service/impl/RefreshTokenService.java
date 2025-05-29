package com.example.employee.service.impl;

import com.example.employee.model.RefreshToken;

import java.util.Optional;

public interface RefreshTokenService {
    Optional<RefreshToken> findByToken(String token);
    RefreshToken createOrUpdateRefreshToken(String employeeCode);
    RefreshToken verifyExpiration(RefreshToken token) ;
    RefreshToken save(RefreshToken token);
}

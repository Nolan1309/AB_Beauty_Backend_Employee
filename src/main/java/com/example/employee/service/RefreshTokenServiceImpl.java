package com.example.employee.service;

import com.example.employee.exception.TokenRefreshException;
import com.example.employee.model.RefreshToken;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.repository.RefreshTokenRepository;
import com.example.employee.service.impl.RefreshTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
public class RefreshTokenServiceImpl implements RefreshTokenService {

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Value("${app.jwtRefreshExpirationMs}")
    private Long refreshTokenDurationMs;

    @Override
    public Optional<RefreshToken> findByToken(String token) {
        return refreshTokenRepository.findByToken(token);
    }

    @Override
    public RefreshToken createOrUpdateRefreshToken(String employeeCode) {
        Optional<RefreshToken> existingToken = refreshTokenRepository.findRefreshTokenByEmployeeEmployeeCode(employeeCode);

        RefreshToken refreshToken;
        if (existingToken.isPresent()) {

            refreshToken = existingToken.get();
            refreshToken.setToken(UUID.randomUUID().toString());
            refreshToken.setExpiryDate(Instant.now().plusMillis(refreshTokenDurationMs));
        } else {
            refreshToken = new RefreshToken();
            refreshToken.setEmployee(employeeRepository.findEmployeeByEmployeeCode(employeeCode));
            refreshToken.setToken(UUID.randomUUID().toString());
            refreshToken.setExpiryDate(Instant.now().plusMillis(refreshTokenDurationMs));
        }
        return refreshTokenRepository.save(refreshToken);
    }

    @Override
    public RefreshToken verifyExpiration(RefreshToken token) {
        if (token.getExpiryDate().compareTo(Instant.now()) < 0) {
            refreshTokenRepository.delete(token);
            throw new TokenRefreshException(token.getToken(), "Refresh token đã hết hạn. Vui lòng đăng nhập lại.");
        }
        return token;
    }
}

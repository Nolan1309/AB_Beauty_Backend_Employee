package com.example.employee.controller;

import com.example.employee.service.impl.JwtTokenService;
import com.example.employee.dto.ApiResponse;
import com.example.employee.dto.auth.LoginRequest;
import com.example.employee.dto.auth.LoginResponse;
import com.example.employee.exception.TokenRefreshException;
import com.example.employee.model.Employee;
import com.example.employee.service.impl.EmployeeService;
import com.example.employee.service.impl.RefreshTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private JwtTokenService jwtTokenService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RefreshTokenService refreshTokenService;

    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {

        String identifier = loginRequest.getEmail();
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(identifier, loginRequest.getPassword())
            );
            // Nếu xác thực thành công
            if (authentication.isAuthenticated()) {
                String jwt = jwtTokenService.generateToken(identifier);
                Employee employee = employeeService.getEmployeeByEmail(identifier);
                String refreshToken = refreshTokenService.createOrUpdateRefreshToken(employee.getEmployeeCode()).getToken();
                String role = employee.getRole().getName();
                LoginResponse.Data data = new LoginResponse.Data(jwt, refreshToken, role, employee.getEmployeeName(), employee.getEmployeeEmail());
                LoginResponse response = new LoginResponse(200, "Login successful", data, new Date());
                return ResponseEntity.ok(response);
            }
        } catch (AuthenticationException e) {
            return ResponseEntity.status(400).body(new LoginResponse(400, "Authentication failed", null, new Date()));
        }
        return ResponseEntity.status(400).body(new LoginResponse(400, "Authentication failed", null, new Date()));
    }
    @GetMapping("/refresh-token")
    public ResponseEntity<?> refreshToken(@RequestParam("refreshToken") String requestRefreshToken) {
        return refreshTokenService.findByToken(requestRefreshToken)
                .map(refreshTokenService::verifyExpiration)
                .map(refreshToken -> {
                    String email = refreshToken.getEmployee().getEmail();
                    String newAccessToken = jwtTokenService.generateToken(email);
                    Employee employee = employeeService.getEmployeeByEmail(email);
                    LoginResponse.Data data = new LoginResponse.Data(newAccessToken, requestRefreshToken, employee.getRole().getName(), employee.getEmployeeName(), employee.getEmployeeEmail());
                    LoginResponse response = new LoginResponse(200, "Token refreshed successfully", data, new Date());
                    return ResponseEntity.ok(response);
                })
                .orElseThrow(() -> new TokenRefreshException(requestRefreshToken, "Refresh token is invalid or expired."));
    }
    
    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestParam("refreshToken") String refreshToken) {
        return refreshTokenService.findByToken(refreshToken)
                .map(token -> {
                    token.setRevoked(true);
                    refreshTokenService.save(token);
                    Map<String, Object> responseData = new HashMap<>();
                    responseData.put("timestamp", new Date());
                    
                    ApiResponse<Map<String, Object>> response = ApiResponse.success("Đăng xuất thành công", responseData);
                    return ResponseEntity.ok(response);
                })
                .orElse(ResponseEntity.ok(ApiResponse.success("Đăng xuất thành công", null)));
    }
}

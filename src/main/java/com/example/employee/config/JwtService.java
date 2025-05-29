package com.example.employee.config;


import com.example.employee.model.Company;
import com.example.employee.model.Employee;
import com.example.employee.model.Role;
import com.example.employee.service.impl.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cglib.core.internal.Function;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class JwtService {

    @Value("${app.jwtSecret}")
    private String SECRET;
    @Autowired
    private UserService userService;

    public String generateToken(String email) {
        Map<String, Object> claims = new HashMap<>();
        boolean isAdmin = false;
        boolean isUser = false;
        Employee account = userService.findByEmail(email);
        if (account != null && account.getAuthorities().size() > 0) {
            Role role = account.getRole();
            if (role != null) {
                if (role.getName().equals("ADMIN")) {
                    isAdmin = true;
                }
                if (role.getName().equals("USER")) {
                    isUser = true;
                }
            }
        }
        claims.put("isAdmin", isAdmin);
        claims.put("isUser", isUser);
        
        // Thêm thông tin công ty vào token từ department
        if (account != null && account.getDepartment() != null && account.getDepartment().getCompany() != null) {
            Company company = account.getDepartment().getCompany();
            claims.put("companyCode", company.getCompanyCode());
            claims.put("companyName", company.getCompanyName());
        }

        return createToken(claims, email);
    }

    // Tạo JWT với các claim đã chọn
    private String createToken(Map<String, Object> claims, String tenDangNhap) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(tenDangNhap)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000)) // JWT hết hạn sau 60 phút
                .signWith(SignatureAlgorithm.HS256, getSigneKey())
                .compact();
    }

    // Lấy serect key
    private Key getSigneKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    // Trích xuất thông tin
    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(getSigneKey()).parseClaimsJws(token).getBody();
    }

    // Trích xuất thông tin cho 1 claim
    public <T> T extractClaim(String token, Function<Claims, T> claimsTFunction) {
        final Claims claims = extractAllClaims(token);
        return claimsTFunction.apply(claims);
    }

    // Kiểm tra tời gian hết hạn từ JWT
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    // Kiểm tra tời gian hết hạn từ JWT
    public String extractUsername(String token) {
        String username = extractClaim(token, Claims::getSubject);
        return username;
    }

    // Kiểm tra cái JWT đã hết hạn
    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // Kiểm tra tính hợp lệ
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String tenDangNhap = extractUsername(token);
        return (tenDangNhap.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

//    public String getEmailFromToken(String token) {
//        return extractUsername(token); // Trả về email từ subject (username)
//    }
}
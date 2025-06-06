package com.example.employee.util;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
@Component
public class PasswordEncoderUtil {
    private final PasswordEncoder passwordEncoder;
    public PasswordEncoderUtil() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }
    public String encode(String password) {
        return passwordEncoder.encode(password);
    }
    public boolean matches(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
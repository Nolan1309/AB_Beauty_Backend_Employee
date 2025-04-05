package com.example.employee.service.impl;

import com.example.employee.model.Employee;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Collection;

public interface UserService extends UserDetailsService {
    Employee findByEmail(String email);

    Collection<? extends GrantedAuthority> getAuthorities(Employee employee);
}

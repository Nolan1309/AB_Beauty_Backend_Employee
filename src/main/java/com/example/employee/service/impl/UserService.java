package com.example.employee.service.impl;

import com.example.employee.model.Employee;

public interface UserService {
    public Employee findByEmail(String email);
}

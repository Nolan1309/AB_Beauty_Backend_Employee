package com.example.employee.service.impl;

import com.example.employee.dto.CouponResponseDTO;
import com.example.employee.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();

    Page<Employee> getEmployeesInSameCompany(String employeeCode, Pageable pageable);
    Employee getEmployeeById(String employeeCode);

    Employee getEmployeeByEmail(String email);

    Employee createEmployee(Employee employee);
    Employee updateEmployee(String employeeCode,Employee employee);
    void deleteEmployee(String employeeCode);
}

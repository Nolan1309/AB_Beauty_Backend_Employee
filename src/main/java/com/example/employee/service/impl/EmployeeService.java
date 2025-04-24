package com.example.employee.service.impl;

import com.example.employee.dto.ApiResponse;
import com.example.employee.dto.employee.EmployeeDTO;
import com.example.employee.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    ApiResponse<Page<?>> getAllEmployee(Pageable pageable);

    Page<Employee> getEmployeesInSameCompany(String employeeCode, Pageable pageable);
    ApiResponse<?> getEmployeeByEmployeeCode(String employeeCode);
    Employee getEmployeeByEmail(String email);

    ApiResponse<?> createEmployee(EmployeeDTO employee);
    ApiResponse<?> updateEmployee(String employeeCode, EmployeeDTO employee);
    ApiResponse<?> deletedEmployee(String employeeCode);
}

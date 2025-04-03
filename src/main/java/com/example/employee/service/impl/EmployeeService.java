package com.example.employee.service.impl;

import com.example.employee.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();
    Employee getEmployeeById(String employeeCode);

    Employee createEmployee(Employee employee);
    Employee updateEmployee(String employeeCode,Employee employee);
    void deleteEmployee(String employeeCode);
}

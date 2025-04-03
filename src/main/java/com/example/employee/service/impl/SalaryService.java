package com.example.employee.service.impl;

import com.example.employee.model.Salary;

import java.util.List;

public interface SalaryService {
    List<Salary> getAllSalary();
    Salary getSalaryByEmployeeCode(String employeeCode);

    Salary createSalary(Salary salary);
    Salary updateSalary(String employeeCode, Salary salary);
    void deleteSalary(String employeeCode);
}

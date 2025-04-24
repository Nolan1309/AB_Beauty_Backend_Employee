package com.example.employee.service.impl;

import com.example.employee.dto.salary.SalaryResponseDTO;
import com.example.employee.model.Salary;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SalaryService {
    List<Salary> getAllSalary();
    SalaryResponseDTO getSalaryByEmployeeCode(String employeeCode, Integer salaryId);
    Salary createSalary(Salary salary);
    Salary updateSalary(String employeeCode, Salary salary);
    void deleteSalary(String employeeCode);
    Page<SalaryResponseDTO> getSalariesByEmployeeCodeAndYear(String employeeCode, int year, int page, int size);
}

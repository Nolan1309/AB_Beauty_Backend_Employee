package com.example.employee.service;

import com.example.employee.model.Salary;
import com.example.employee.service.impl.SalaryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryServiceImpl implements SalaryService {


    @Override
    public List<Salary> getAllSalary() {
        return null;
    }

    @Override
    public Salary getSalaryByEmployeeCode(String employeeCode) {
        return null;
    }

    @Override
    public Salary createSalary(Salary salary) {
        return null;
    }

    @Override
    public Salary updateSalary(String employeeCode, Salary salary) {
        return null;
    }

    @Override
    public void deleteSalary(String employeeCode) {

    }
}

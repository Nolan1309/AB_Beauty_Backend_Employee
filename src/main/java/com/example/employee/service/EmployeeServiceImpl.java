package com.example.employee.service;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.service.impl.EmployeeService;
import com.example.employee.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService, UserService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployee() {
        return null;
    }

    @Override
    public Employee getEmployeeById(String employeeCode) {
        return null;
    }

    @Override
    public Employee createEmployee(Employee employeeCode) {
        return null;
    }

    @Override
    public Employee updateEmployee(String employeeCode,Employee employee) {
        return null;
    }

    @Override
    public void deleteEmployee(String employeeCode) {

    }

    @Override
    public Employee findByEmail(String email) {
        return null;
    }
}

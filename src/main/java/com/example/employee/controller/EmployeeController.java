package com.example.employee.controller;

import com.example.employee.model.Employee;
import com.example.employee.service.impl.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "${allowed.origins}", allowCredentials = "true")
@RestController
@RequestMapping( "/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployee();
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/{employeeCode}")
    public Employee getEmployeeById(@PathVariable String employeeCode) {
        return employeeService.getEmployeeById(employeeCode);
    }

    @PutMapping("/{employeeCode}")
    public Employee updateEmployee(@PathVariable String employeeCode, @RequestBody Employee employee) {
        return employeeService.updateEmployee(employeeCode, employee);
    }

    @DeleteMapping("/{employeeCode}")
    public void deleteEmployee(@PathVariable String employeeCode) {
        employeeService.deleteEmployee(employeeCode);
    }
}

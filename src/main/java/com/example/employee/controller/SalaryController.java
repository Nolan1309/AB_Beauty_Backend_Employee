package com.example.employee.controller;

import com.example.employee.model.Salary;
import com.example.employee.service.impl.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "${allowed.origins}", allowCredentials = "true")
@RestController
@RequestMapping("/api/salary")
public class SalaryController {
    @Autowired
    private SalaryService salaryService;

    @GetMapping
    public List<Salary> getAllSalaries() {
        return salaryService.getAllSalary();
    }

    @GetMapping("/{employeeCode}")
    public Salary getSalaryById(@PathVariable String employeeCode) {
        return salaryService.getSalaryByEmployeeCode(employeeCode);
    }

    @PostMapping
    public Salary createSalary(@RequestBody Salary salary) {
        return salaryService.createSalary(salary);
    }

    @PutMapping("/{employeeCode}")
    public Salary updateSalary(@PathVariable String employeeCode, @RequestBody Salary salary) {
        return salaryService.updateSalary(employeeCode, salary);
    }

    @DeleteMapping("/{employeeCode}")
    public void deleteSalary(@PathVariable String employeeCode) {
        salaryService.deleteSalary(employeeCode);
    }
}

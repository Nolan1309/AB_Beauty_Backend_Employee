package com.example.employee.controller;

import com.example.employee.model.Department;
import com.example.employee.service.impl.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "${allowed.origins}", allowCredentials = "true")
@RestController
@RequestMapping( "/api/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartment();
    }

    @GetMapping("/{departmentCode}")
    public Department getDepartmentById(@PathVariable String departmentCode) {
        return departmentService.getDepartmentById(departmentCode);
    }

    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.createDepartment(department);
    }

    @PutMapping("/{departmentCode}")
    public Department updateDepartment(@PathVariable String departmentCode, @RequestBody Department department) {
        return departmentService.updateDepartment(departmentCode, department);
    }

    @DeleteMapping("/{departmentCode}")
    public void deleteDepartment(@PathVariable String departmentCode) {
        departmentService.deleteDepartment(departmentCode);
    }
}

package com.example.employee.controller;

import com.example.employee.dto.ApiResponse;
import com.example.employee.dto.department.DepartmentDTO;
import com.example.employee.service.impl.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public ApiResponse<Page<?>> getAllDepartments(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "50") int size) {
        Pageable pageable;
        pageable = PageRequest.of(page, size);
        return departmentService.getAllDepartment(pageable);
    }

    @GetMapping("/{departmentCode}")
    public ApiResponse<?> getDepartmentById(@PathVariable String departmentCode) {
        return departmentService.getDepartmentByDepartmentCode(departmentCode);
    }

    @GetMapping("/company/{companyCode}")
    public ApiResponse<?> getDepartmentsByCompany(@PathVariable String companyCode) {
        return departmentService.getDepartmentsByCompanyCode(companyCode);
    }

    @PostMapping
    public ApiResponse<?> createDepartment(@RequestBody DepartmentDTO department) {
        return departmentService.createDepartment(department);
    }

    @PutMapping("/{departmentCode}")
    public ApiResponse<?> updateDepartment(@PathVariable String departmentCode, @RequestBody DepartmentDTO department) {
        return departmentService.updateDepartment(departmentCode, department);
    }

    @DeleteMapping("/{departmentCode}")
    public ApiResponse<?> deleteDepartment(@PathVariable String departmentCode) {
        return departmentService.deletedDepartment(departmentCode);
    }
}

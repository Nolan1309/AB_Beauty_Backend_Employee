package com.example.employee.service.impl;

import com.example.employee.dto.ApiResponse;
import com.example.employee.dto.department.DepartmentDTO;
import com.example.employee.model.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DepartmentService {
    ApiResponse<Page<?>>  getAllDepartment(Pageable pageable);
    ApiResponse<?> getDepartmentByDepartmentCode(String departmentCode);
    ApiResponse<?> getDepartmentsByCompanyCode(String companyCode);
    ApiResponse<?> createDepartment(DepartmentDTO departmentDTO);
    ApiResponse<?> updateDepartment(String departmentCode, DepartmentDTO department);
    ApiResponse<?> deletedDepartment(String departmentCode);
}

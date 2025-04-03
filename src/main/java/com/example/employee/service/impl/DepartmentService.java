package com.example.employee.service.impl;

import com.example.employee.model.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartment();
    Department getDepartmentById(String departmentCode);

    Department createDepartment(Department departmentCode);
    Department updateDepartment(String departmentCode, Department department);
    void deleteDepartment(String departmentCode);
}

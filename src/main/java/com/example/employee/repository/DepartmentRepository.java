package com.example.employee.repository;

import com.example.employee.model.Company;
import com.example.employee.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {
    Department findDepartmentByDepartmentCode(String departmentCode);
    void deleteDepartmentByDepartmentCode(String departmentCode);
}

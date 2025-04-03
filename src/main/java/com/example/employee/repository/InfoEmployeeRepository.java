package com.example.employee.repository;

import com.example.employee.model.Company;
import com.example.employee.model.InfoEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoEmployeeRepository extends JpaRepository<InfoEmployee, Integer> {
    // Phương thức tìm theo employee và id
    InfoEmployee findInfoEmployeeByEmployeeEmployeeCodeAndId(String employeeCode, Integer id);
}

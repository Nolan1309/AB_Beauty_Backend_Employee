package com.example.employee.repository;

import com.example.employee.model.Company;
import com.example.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Employee findEmployeeByEmployeeCode(String employeeCode);
    void deleteEmployeeByEmployeeCode(String employeeCode);
}

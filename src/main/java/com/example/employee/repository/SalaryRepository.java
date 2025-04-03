package com.example.employee.repository;

import com.example.employee.model.Company;
import com.example.employee.model.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepository extends JpaRepository<Salary,Salary> {
    Salary findSalaryById(Integer Id);
    void deleteSalaryById(Integer companyCode);
}

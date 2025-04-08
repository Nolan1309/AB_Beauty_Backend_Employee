package com.example.employee.repository;

import com.example.employee.model.Company;
import com.example.employee.model.Salary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(exported = false)
public interface SalaryRepository extends JpaRepository<Salary,Salary> {
    Salary findSalaryById(Integer Id);
    void deleteSalaryById(Integer companyCode);
    Salary findByEmployeeEmployeeCodeAndId(String employeeCode, Integer salaryId);
    @Query("SELECT s FROM Salary s WHERE s.employee.employeeCode = :employeeCode AND YEAR(s.salaryDate) = :year")
    Page<Salary> findSalariesByEmployeeCodeAndYear(@Param("employeeCode") String employeeCode, @Param("year") int year, Pageable pageable);
}

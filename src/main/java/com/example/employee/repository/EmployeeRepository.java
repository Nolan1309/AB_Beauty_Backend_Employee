package com.example.employee.repository;

import com.example.employee.dto.InfoEmployeePublicDTO;
import com.example.employee.model.Company;
import com.example.employee.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(exported = false)
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Employee findEmployeeByEmployeeCode(String employeeCode);

    Optional<Employee> findEmployeeByEmail(String email);


    @Query(value = "SELECT e.* FROM employee e " +
            "JOIN department d ON e.department_code = d.department_code " +
            "JOIN company c ON d.company_code = c.company_code " +
            "WHERE c.company_code = :companyCode",
            countQuery = "SELECT COUNT(*) FROM employee e " +
                    "JOIN department d ON e.department_code = d.department_code " +
                    "JOIN company c ON d.company_code = c.company_code " +
                    "WHERE c.company_code = :companyCode",
            nativeQuery = true)
    Page<Employee> findByCompanyCode(@Param("companyCode") String companyCode, Pageable pageable);




}

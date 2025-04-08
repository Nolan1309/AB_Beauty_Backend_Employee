package com.example.employee.repository;

import com.example.employee.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(exported = false)
public interface CompanyRepository extends JpaRepository<Company, Integer> {
        Company findCompanyByCompanyCode(String companyCode);
        void deleteCompanyByCompanyCode(String companyCode);
}

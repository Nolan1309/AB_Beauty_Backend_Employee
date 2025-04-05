package com.example.employee.service.impl;

import com.example.employee.model.Company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompany();
    Company getCompanyByCompanyCode(String companyCode);

    Company createCompany(Company company);
    Company updateCompany(String couponCode,Company company);
    void deleteCompany(String companyCode);
}

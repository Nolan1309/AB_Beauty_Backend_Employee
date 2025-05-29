package com.example.employee.service.impl;

import com.example.employee.dto.ApiResponse;
import com.example.employee.dto.company.CompanyDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface CompanyService {
    ApiResponse<Page<?>> getAllCompany(Pageable pageable);
    ApiResponse<List<?>> getAllCompany();
    ApiResponse<?> getCompanyByCompanyCode(String companyCode);
    ApiResponse<?> createCompany(CompanyDTO companyDTO);
    ApiResponse<?> updateCompany(String companyCode, CompanyDTO companyDTO);
    ApiResponse<Void> deletedCompany(String companyCode);
}

package com.example.employee.service;

import com.example.employee.model.Company;
import com.example.employee.repository.CompanyRepository;
import com.example.employee.service.impl.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompanyById(String companyCode) {
        return companyRepository.findCompanyByCompanyCode(companyCode);
    }

    @Override
    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company updateCompany(String companyCode, Company company) {
        return companyRepository.saveAndFlush(company);
    }

    @Override
    public void deleteCompany(String companyCode) {
         companyRepository.deleteCompanyByCompanyCode(companyCode);
    }
}

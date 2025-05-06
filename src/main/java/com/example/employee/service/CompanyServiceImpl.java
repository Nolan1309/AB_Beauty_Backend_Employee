package com.example.employee.service;

import com.example.employee.dto.ApiResponse;
import com.example.employee.dto.company.CompanyDTO;
import com.example.employee.exception.DataNotFoundException;
import com.example.employee.mapper.CompanyMapper;
import com.example.employee.model.Company;
import com.example.employee.model.Department;
import com.example.employee.repository.CompanyRepository;
import com.example.employee.repository.DepartmentRepository;
import com.example.employee.service.impl.CompanyService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public ApiResponse<Page<?>> getAllCompany(Pageable pageable) {
        Page<Company> companies = companyRepository.findAll(pageable);
        return new ApiResponse<>("Successfully.", companies, 200);
    }
    @Override
    public ApiResponse<List<?>> getAllCompany() {
        List<Company> companies = companyRepository.findAll();
        return new ApiResponse<>("Successfully.", companies, 200);
    }
    @Override
    public ApiResponse<Company> getCompanyByCompanyCode(String companyCode) {
        Company company = companyRepository.findCompanyByCompanyCode(companyCode);
        if (company == null) {
            throw new DataNotFoundException("Company not found with code: " + companyCode);
        }
        return new ApiResponse<>("Company found successfully.", company, 200);
    }
    @Override
    @Transactional
    public ApiResponse<?> createCompany(CompanyDTO companyDTO) {
        try {
            Company existingCompany = companyRepository.findCompanyByCompanyCode(companyDTO.getCompanyCode());
            if (existingCompany != null) {
                return new ApiResponse<>("Company with code already exists.", null, 400);
            }
            Company company = companyMapper.toEntity(companyDTO);
            company = companyRepository.save(company);
            return new ApiResponse<>("Company created successfully.", company, 200);
        } catch (Exception e) {
            return new ApiResponse<>("Error occurred while creating company: " + e.getMessage(), null, 500);
        }
    }
    @Override
    @Transactional
    public ApiResponse<?> updateCompany(String companyCode, CompanyDTO companyDTO) {
        try {
            Company existingCompany = companyRepository.findCompanyByCompanyCode(companyCode);
            if (existingCompany == null) {
                return new ApiResponse<>("Company not found with code: " + companyCode, null, 404);
            }


            existingCompany.setCompanyAddress(companyDTO.getCompanyAddress());
            existingCompany.setCompanyBrands(companyDTO.getCompanyBrands());
            existingCompany.setCompanyMst(companyDTO.getCompanyMst());
            existingCompany.setCompanyPhone(companyDTO.getCompanyPhone());
            existingCompany.setCompanyName(companyDTO.getCompanyName());

            Company updatedCompany = companyRepository.saveAndFlush(existingCompany);
            return new ApiResponse<>("Company updated successfully.", updatedCompany, 200);
        } catch (Exception e) {

            return new ApiResponse<>("Error occurred while updating company: " + e.getMessage(), null, 500);
        }
    }

    @Override
    @Transactional
    public ApiResponse<Void> deletedCompany(String companyCode) {
        Company existingCompany = companyRepository.findCompanyByCompanyCode(companyCode);
        if (existingCompany == null) {
            return new ApiResponse<>("Company not found.", null, 404);
        }
        List<Department> departments = departmentRepository.findDepartmentByCompany_CompanyCode(companyCode);
        if (!departments.isEmpty()) {
            return new ApiResponse<>("Cannot delete company because there are departments referencing this company.", null, 400);
        }
        try {
            companyRepository.delete(existingCompany);
        } catch (Exception e) {
            return new ApiResponse<>("Error occurred while deleting company: " + e.getMessage(), null, 500);
        }
        return new ApiResponse<>("Company deleted successfully.", null, 200);
    }
}

package com.example.employee.controller;

import com.example.employee.dto.ApiResponse;
import com.example.employee.dto.company.CompanyDTO;
import com.example.employee.service.impl.CompanyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/api/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping
    public ApiResponse<Page<?>> getAllCompanies(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "50") int size) {
        Pageable pageable;
        pageable = PageRequest.of(page, size);
        return companyService.getAllCompany(pageable);
    }

    @GetMapping("/list")
    public ApiResponse<List<?>> getAllCompaniesList() {
        return companyService.getAllCompany();
    }

    @GetMapping("/{companyCode}")
    public ApiResponse<?> getCompanyById(@PathVariable String companyCode) {
        return companyService.getCompanyByCompanyCode(companyCode);
    }
    @PostMapping
    public ApiResponse<?> createCompany(@RequestBody @Valid CompanyDTO company) {
        return companyService.createCompany(company);
    }

    @PutMapping("/{companyCode}")
    public ApiResponse<?> updateCompany(@PathVariable String companyCode, @RequestBody CompanyDTO company) {
        return companyService.updateCompany(companyCode, company);
    }

    @DeleteMapping("/{companyCode}")
    public ApiResponse<Void> deleteCompany(@PathVariable String companyCode) {
        return companyService.deletedCompany(companyCode);
    }

}

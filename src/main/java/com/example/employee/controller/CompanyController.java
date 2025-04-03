package com.example.employee.controller;

import com.example.employee.model.Company;
import com.example.employee.service.CompanyServiceImpl;
import com.example.employee.service.impl.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "${allowed.origins}", allowCredentials = "true")
@RestController
@RequestMapping( "/api/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping
    public List<Company> getAllCompanies() {
        return companyService.getAllCompany();
    }

    @GetMapping("/{companyCode}")
    public Company getCompanyById(@PathVariable String companyCode) {
        return companyService.getCompanyById(companyCode);
    }

    @PostMapping
    public Company createCompany(@RequestBody Company company) {
        return companyService.createCompany(company);
    }

    @PutMapping("/{companyCode}")
    public Company updateCompany(@PathVariable String companyCode, @RequestBody Company company) {
        return companyService.updateCompany(companyCode, company);
    }

    @DeleteMapping("/{companyCode}")
    public void deleteCompany(@PathVariable String companyCode) {
        companyService.deleteCompany(companyCode);
    }

}

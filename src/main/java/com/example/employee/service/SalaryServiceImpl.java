package com.example.employee.service;

import com.example.employee.dto.salary.SalaryResponseDTO;
import com.example.employee.model.Salary;
import com.example.employee.repository.SalaryRepository;
import com.example.employee.service.impl.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SalaryServiceImpl implements SalaryService {


    @Autowired
    private SalaryRepository salaryRepository;

    @Override
    public List<Salary> getAllSalary() {
        return null;
    }

    @Override
    public SalaryResponseDTO getSalaryByEmployeeCode(String employeeCode, Integer salaryId) {
        Salary salary = salaryRepository.findByEmployeeEmployeeCodeAndId(employeeCode, salaryId);
        if (salary == null) {
            return null;
        }
        return new SalaryResponseDTO(
                salary.getId(),
                salary.getEmployee().getEmployeeCode(),
                salary.getEmployee().getEmployeeName(),
                salary.getSalaryDate(),
                salary.getSalaryBasic(),
                salary.getSalaryBonus(),
                salary.getSalaryDeductions(),
                salary.getSalaryTotalSalary(),
                salary.getSalaryPaymentStatus(),
                salary.getSalaryLinkFile()
        );
    }

    @Override
    public Salary createSalary(Salary salary) {
        return null;
    }

    @Override
    public Salary updateSalary(String employeeCode, Salary salary) {
        return null;
    }

    @Override
    public void deleteSalary(String employeeCode) {

    }
    @Override
    public Page<SalaryResponseDTO> getSalariesByEmployeeCodeAndYear(String employeeCode, int year, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Salary> salaryPage = salaryRepository.findSalariesByEmployeeCodeAndYear(employeeCode, year, pageable);
        if (salaryPage.isEmpty()) {
            return new PageImpl<>(Collections.emptyList(), pageable, 0);
        }
        List<SalaryResponseDTO> salaryDTOList = salaryPage.getContent().stream()
                .map(salary -> new SalaryResponseDTO(
                        salary.getId(),
                        salary.getEmployee().getEmployeeCode(),
                        salary.getEmployee().getEmployeeName(),
                        salary.getSalaryDate(),
                        salary.getSalaryBasic(),
                        salary.getSalaryBonus(),
                        salary.getSalaryDeductions(),
                        salary.getSalaryTotalSalary(),
                        salary.getSalaryPaymentStatus(),
                        salary.getSalaryLinkFile()))
                .collect(Collectors.toList());
        return new PageImpl<>(salaryDTOList, pageable, salaryPage.getTotalElements());
    }

}

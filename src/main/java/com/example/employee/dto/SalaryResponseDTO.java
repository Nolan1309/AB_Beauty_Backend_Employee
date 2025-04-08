package com.example.employee.dto;

import lombok.Data;

import java.util.Date;
@Data
public class SalaryResponseDTO {
    private Integer id;
    private String employeeCode;
    private String employeeName;
    private Date salaryDate;
    private Double salaryBasic;
    private Double salaryBonus;
    private Double salaryDeductions;
    private Double salaryTotalSalary;
    private String salaryPaymentStatus;
    private String salaryLinkFile;

    public SalaryResponseDTO() {
    }

    public SalaryResponseDTO(Integer id, String employeeCode, String employeeName, Date salaryDate, Double salaryBasic, Double salaryBonus, Double salaryDeductions, Double salaryTotalSalary, String salaryPaymentStatus, String salaryLinkFile) {
        this.id = id;
        this.employeeCode = employeeCode;
        this.employeeName = employeeName;
        this.salaryDate = salaryDate;
        this.salaryBasic = salaryBasic;
        this.salaryBonus = salaryBonus;
        this.salaryDeductions = salaryDeductions;
        this.salaryTotalSalary = salaryTotalSalary;
        this.salaryPaymentStatus = salaryPaymentStatus;
        this.salaryLinkFile = salaryLinkFile;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Date getSalaryDate() {
        return salaryDate;
    }

    public void setSalaryDate(Date salaryDate) {
        this.salaryDate = salaryDate;
    }

    public Double getSalaryBasic() {
        return salaryBasic;
    }

    public void setSalaryBasic(Double salaryBasic) {
        this.salaryBasic = salaryBasic;
    }

    public Double getSalaryBonus() {
        return salaryBonus;
    }

    public void setSalaryBonus(Double salaryBonus) {
        this.salaryBonus = salaryBonus;
    }

    public Double getSalaryDeductions() {
        return salaryDeductions;
    }

    public void setSalaryDeductions(Double salaryDeductions) {
        this.salaryDeductions = salaryDeductions;
    }

    public Double getSalaryTotalSalary() {
        return salaryTotalSalary;
    }

    public void setSalaryTotalSalary(Double salaryTotalSalary) {
        this.salaryTotalSalary = salaryTotalSalary;
    }

    public String getSalaryPaymentStatus() {
        return salaryPaymentStatus;
    }

    public void setSalaryPaymentStatus(String salaryPaymentStatus) {
        this.salaryPaymentStatus = salaryPaymentStatus;
    }

    public String getSalaryLinkFile() {
        return salaryLinkFile;
    }

    public void setSalaryLinkFile(String salaryLinkFile) {
        this.salaryLinkFile = salaryLinkFile;
    }
}

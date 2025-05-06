package com.example.employee.dto.employee;

import lombok.Data;

import java.util.Date;
@Data
public class EmployeeColleaguesDTO {
    private Integer employeeId;
    private String employeeCode;
    private String employeeName;
    private String email;
    private String employeePhoneNumber;
    private Date employeeLastLogin;
    private Short employeeActive;
    private String companyCode;
    private String companyName;

    public EmployeeColleaguesDTO(Integer employeeId, String employeeCode, String employeeName, String email, String employeePhoneNumber, Date employeeLastLogin, Short employeeActive, String companyCode, String companyName) {
        this.employeeId = employeeId;
        this.employeeCode = employeeCode;
        this.employeeName = employeeName;
        this.email = email;
        this.employeePhoneNumber = employeePhoneNumber;
        this.employeeLastLogin = employeeLastLogin;
        this.employeeActive = employeeActive;
        this.companyCode = companyCode;
        this.companyName = companyName;
    }
}

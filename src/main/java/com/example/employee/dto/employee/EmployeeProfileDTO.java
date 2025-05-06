package com.example.employee.dto.employee;

import lombok.Data;

@Data
public class EmployeeProfileDTO {
   private Integer employeeId;
   private String employeeCode;
   private String employeeName;
   private String  email;
   private String  employeePhoneNumber;
   private String  employeeLastLogin;
   private Short employeeActive;
   private String companyCode;
   private String  companyName;
}

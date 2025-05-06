package com.example.employee.dto.department;

import lombok.Data;

import java.util.List;

@Data
public class DepartmentOrganizationDTO {
    private Integer id;
    private String departmentCode;
    private String departmentName;
    private String departmentParent;
    private Integer departmentLevel;
    private String companyCode;
    private String companyName;
    private Integer employeeCount;
}

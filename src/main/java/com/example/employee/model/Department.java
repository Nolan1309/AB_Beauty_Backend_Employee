package com.example.employee.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Entity
@Data
@Table(name = "department")
public class Department {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "department_code", length = 200, nullable = false, unique = true)
    private String departmentCode;

    @ManyToOne
    @JoinColumn(name = "company_code", referencedColumnName = "company_code")
    private Company company;

    @Column(name = "department_name")
    private String departmentName;

    @Column(name = "department_parent")
    private String departmentParent;


    @Column(name = "department_level")
    private Integer departmentLevel;

    public Integer getId() {
        return id;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentParent() {
        return departmentParent;
    }

    public void setDepartmentParent(String departmentParent) {
        this.departmentParent = departmentParent;
    }

    public Integer getDepartmentLevel() {
        return departmentLevel;
    }

    public void setDepartmentLevel(Integer departmentLevel) {
        this.departmentLevel = departmentLevel;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

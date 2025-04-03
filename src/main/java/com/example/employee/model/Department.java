package com.example.employee.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "department_code", length = 200, nullable = false, unique = true)
    private String departmentCode;

    @ManyToOne
    @JoinColumn(name = "company_code", referencedColumnName = "company_code")
    private Company company;

    @Column(name = "department_name",length = 100)
    private String departmentName;

    @Column(name = "department_parent",length = 100)
    private String departmentParent;

    @Column(name = "department_level",length = 100)
    private Integer departmentLevel;
}

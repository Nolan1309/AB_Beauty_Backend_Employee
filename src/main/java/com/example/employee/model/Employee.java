package com.example.employee.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "employee_code",length = 200, nullable = false, unique = true)
    private String employeeCode;

    @Column(name = "employee_name",length = 150, nullable = false)
    private String employeeName;

    @Column(name = "employee_email",length = 100, nullable = false)
    private String employeeEmail;

    @Column(name = "employee_phone",length = 15)
    private String employeePhoneNumber;

    @Temporal(TemporalType.DATE)
    @Column(name = "employee_last_login")
    private Date employeeLastLogin;

    @Column(name = "employee_active")
    private Short employeeActive;

    @Column(name = "employee_total_LTL",precision = 65)
    private BigDecimal employeeTotalLTL = BigDecimal.ZERO;

    @Column(name = "employee_total_LKF",precision = 65)
    private BigDecimal employeeTotalLKF = BigDecimal.ZERO;

    @Column(name = "employee_total_LKF_M",precision = 65)
    private BigDecimal employeeTotalLKF_M = BigDecimal.ZERO;

    @Column(name = "employee_total_LDL",precision = 65)
    private BigDecimal employeeTotalLDL = BigDecimal.ZERO;

    @Column(name = "employee_total_ABD",precision = 65)
    private BigDecimal employeeTotalABD = BigDecimal.ZERO;

    @Column(name = "employee_total_ABT",precision = 65)
    private BigDecimal employeeTotalABT = BigDecimal.ZERO;

    @Column(name = "employee_total_ABBW",precision = 65)
    private BigDecimal employeeTotalABBW = BigDecimal.ZERO;

    @Column(name = "employee_total_ABBW_ABB",precision = 65)
    private BigDecimal employeeTotalABBW_ABB = BigDecimal.ZERO;

    @Column(name = "employee_total_Affiliate",precision = 65)
    private BigDecimal employeeTotalAffiliate = BigDecimal.ZERO;

    @Column(name = "employee_banlance",precision = 65)
    private BigDecimal employeeBalance = BigDecimal.ZERO;

    @Column(name = "employee_total_Withdrat",precision = 65)
    private BigDecimal employeeTotalWithdraw = BigDecimal.ZERO;

    @ManyToOne
    @JoinColumn(name = "department_code", referencedColumnName = "department_code")
    private Department department;
}

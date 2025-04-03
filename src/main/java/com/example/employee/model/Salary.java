package com.example.employee.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "salary")
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "employee_code", referencedColumnName = "employee_code")
    private Employee employee;

    @Temporal(TemporalType.DATE)
    @Column(name = "salary_date")
    private Date salaryDate;

    @Column(name = "salary_bassic",precision = 10)
    private Double salaryBasic;

    @Column(name = "salary_bonus",precision = 10)
    private Double salaryBonus;

    @Column(name = "salary_deductions",precision = 10)
    private Double salaryDeductions;

    @Column(name = "salary_totalSalary",precision = 10)
    private Double salaryTotalSalary;

    @Column(name = "salary_payment_status",length = 20)
    private String salaryPaymentStatus;
}

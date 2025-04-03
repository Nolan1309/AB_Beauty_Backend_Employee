package com.example.employee.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "company_code", length = 100, nullable = false, unique = true)
    private String companyCode;

    @Column(name = "company_name",length = 255)
    private String name;

    @Column(name = "company_mst",length = 20)
    private String mst;

    @Column(name = "company_phone",length = 15)
    private String phone;

    @Lob
    @Column(name = "company_address",columnDefinition = "TEXT")
    private String address;

    @Lob
    @Column(name = "company_brands",columnDefinition = "LONGTEXT")
    private String brands;
}

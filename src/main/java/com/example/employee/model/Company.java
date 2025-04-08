package com.example.employee.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "company_code", length = 100, nullable = false, unique = true)
    private String companyCode;

    @Column(name = "company_name",length = 255)
    private String companyName;

    @Column(name = "company_mst")
    private String companyMst;

    @Column(name = "company_phone")
    private String companyPhone;

    @Lob
    @Column(name = "company_address",columnDefinition = "TEXT")
    private String companyAddress;

    @Lob
    @Column(name = "company_brands",columnDefinition = "LONGTEXT")
    private String companyBrands;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyMst() {
        return companyMst;
    }

    public void setCompanyMst(String companyMst) {
        this.companyMst = companyMst;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyBrands() {
        return companyBrands;
    }

    public void setCompanyBrands(String companyBrands) {
        this.companyBrands = companyBrands;
    }
}

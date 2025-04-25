package com.example.employee.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
// @JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "coupon")
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "company_code", referencedColumnName = "company_code", insertable = false, updatable = false)
    private Company company;


    @Column(name = "company_name",length = 255)
    private String companyName;

    @Column(name = "coupon_code",length = 90, nullable = false)
    private String couponCode;

    @Column(name = "coupon_name",length = 255)
    private String couponName;

    @Column(name = "coupon_description",columnDefinition = "TEXT")
    private String couponDescription;

    @Column(name = "coupon_type")
    private String couponType;

    @Temporal(TemporalType.DATE)
    @Column(name = "coupon_date_start")
    private Date couponDateStart;

    @Temporal(TemporalType.DATE)
    @Column(name = "coupon_date_end")
    private Date couponDateEnd;

    @Column(name = "coupon_discount", precision = 20)
    private BigDecimal couponDiscount;


    @Column(name = "coupon_discount_type")
    private String couponDiscountType;

    @Lob
    @Column(name = "coupon_object",columnDefinition = "LONGTEXT")
    private String couponObjects;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public String getCouponDescription() {
        return couponDescription;
    }

    public void setCouponDescription(String couponDescription) {
        this.couponDescription = couponDescription;
    }

    public String getCouponType() {
        return couponType;
    }

    public void setCouponType(String couponType) {
        this.couponType = couponType;
    }

    public Date getCouponDateStart() {
        return couponDateStart;
    }

    public void setCouponDateStart(Date couponDateStart) {
        this.couponDateStart = couponDateStart;
    }

    public Date getCouponDateEnd() {
        return couponDateEnd;
    }

    public void setCouponDateEnd(Date couponDateEnd) {
        this.couponDateEnd = couponDateEnd;
    }

    public BigDecimal getCouponDiscount() {
        return couponDiscount;
    }

    public void setCouponDiscount(BigDecimal couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    public String getCouponDiscountType() {
        return couponDiscountType;
    }

    public void setCouponDiscountType(String couponDiscountType) {
        this.couponDiscountType = couponDiscountType;
    }

    public String getCouponObjects() {
        return couponObjects;
    }

    public void setCouponObjects(String couponObjects) {
        this.couponObjects = couponObjects;
    }
}

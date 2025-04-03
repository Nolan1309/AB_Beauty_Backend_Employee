package com.example.employee.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
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

    @Column(name = "coupon_code",length = 90, nullable = false,unique = true)
    private String couponCode;

    @Column(name = "coupon_name",length = 255)
    private String couponName;

    @Column(name = "coupon_description",columnDefinition = "TEXT")
    private String couponDescription;

    @Column(name = "coupon_type",length = 90)
    private String couponType;

    @Temporal(TemporalType.DATE)
    @Column(name = "coupon_date_start")
    private Date couponDateStart;

    @Temporal(TemporalType.DATE)
    @Column(name = "coupon_date_end")
    private Date couponDateEnd;

    @Column(name = "coupon_discount", precision = 20)
    private BigDecimal couponDiscount;


    @Column(name = "coupon_discount_type",length = 100)
    private String couponDiscountType;

    @Lob
    @Column(name = "coupon_object",columnDefinition = "LONGTEXT")
    private String couponObjects;
}

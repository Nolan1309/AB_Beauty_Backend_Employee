package com.example.employee.dto.coupon;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class CouponDTO {
    private Integer id;
    private String companyName;
    private String couponCode;
    private String couponName;
    private String couponDescription;
    private String couponType;
    private Date couponDateStart;
    private Date couponDateEnd;
    private BigDecimal couponDiscount;
    private String couponDiscountType;
}

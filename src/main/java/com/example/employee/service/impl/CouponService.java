package com.example.employee.service.impl;

import com.example.employee.dto.ApiResponse;
import com.example.employee.dto.coupon.CouponDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CouponService {
    ApiResponse<Page<?>> getAllCoupon(String companyCode, Double discountValue, String startDate,String couponCode, String couponName, Pageable pageable);
    // ApiResponse<?> getCouponByCouponCode(String couponCode, String companyCode);
    ApiResponse<?> createCoupon(CouponDTO coupon, String companyCode);
    ApiResponse<?> updateCoupon(String couponCode, String companyCode,CouponDTO coupon);
    ApiResponse<?> deletedCoupon(String couponCode, String companyCode);
    ApiResponse<Page<?>> searchCoupons(String couponCode, String couponName, Pageable pageable);
    ApiResponse<Page<?>> searchCouponsByCompany(String couponCode, String couponName, String companyCode, Pageable pageable);
}

package com.example.employee.service.impl;

import com.example.employee.model.Coupon;

import java.util.List;

public interface CouponService {
    List<Coupon> getAllCoupon();
    Coupon getCouponById(String couponCode);

    Coupon createCoupon(Coupon coupon);
    Coupon updateCoupon(String couponCode,Coupon coupon);
    void deleteCoupon(String couponCode);
}

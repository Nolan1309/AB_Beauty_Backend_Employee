package com.example.employee.service.impl;

import com.example.employee.dto.CouponResponseDTO;
import com.example.employee.model.Coupon;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CouponService {
    List<Coupon> getAllCoupon();
    Page<CouponResponseDTO> getCouponsWithPagination(int page , int size);
    Coupon getCouponById(String couponCode);

    Coupon createCoupon(Coupon coupon);
    Coupon updateCoupon(String couponCode,Coupon coupon);
    void deleteCoupon(String couponCode);

     CouponResponseDTO convertToCouponDTO(Coupon coupon) ;
}

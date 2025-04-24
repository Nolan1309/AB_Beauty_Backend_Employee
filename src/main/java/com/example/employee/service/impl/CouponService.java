package com.example.employee.service.impl;

import com.example.employee.dto.ApiResponse;
import com.example.employee.dto.coupon.CouponDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CouponService {
    ApiResponse<Page<?>> getAllCoupon(Pageable pageable);
    // ApiResponse<?> getCouponByCouponCode(String couponCode, String companyCode);
    ApiResponse<?> createCoupon(CouponDTO coupon, String companyCode);
    ApiResponse<?> updateCoupon(String couponCode, String companyCode,CouponDTO coupon);
    ApiResponse<?> deletedCoupon(String couponCode, String companyCode);
    
    /**
     * Tìm kiếm khuyến mãi theo mã hoặc tên và phân trang kết quả
     * @param couponCode mã khuyến mãi (có thể null)
     * @param couponName tên khuyến mãi (có thể null)
     * @param pageable thông tin phân trang (page, size)
     * @return ApiResponse chứa Page các khuyến mãi thỏa mãn điều kiện
     */
    ApiResponse<Page<?>> searchCoupons(String couponCode, String couponName, Pageable pageable);
    
    ApiResponse<Page<?>> searchCouponsByCompany(String couponCode, String couponName, String companyCode, Pageable pageable);
//    CouponDTO convertToCouponDTO(Coupon coupon) ;
}

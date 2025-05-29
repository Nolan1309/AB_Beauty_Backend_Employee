package com.example.employee.controller;

import com.example.employee.dto.ApiResponse;
import com.example.employee.dto.coupon.CouponDTO;
import com.example.employee.service.impl.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/coupon")
public class CouponController {

    @Autowired
    private CouponService couponService;

    @GetMapping
    public ApiResponse<Page<?>> getAllCoupons(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "50") int size,
            @RequestParam(required = false) String companyCode, // Đổi companyName thành companyCode
            @RequestParam(required = false) Double discount, // Thêm tham số mức giảm giá
            @RequestParam(required = false) String startDate, // Thêm tham số ngày bắt đầu
            @RequestParam(required = false) String couponCode, // Thêm tham số mã coupon
            @RequestParam(required = false) String couponName) { // Thêm tham số tên coupon
        Pageable pageable = PageRequest.of(page, size);
        return couponService.getAllCoupon(companyCode, discount, startDate, couponCode, couponName, pageable);
    }

    //ADMIN
    @GetMapping("/search")
    public ApiResponse<Page<?>> searchCoupons(
            @RequestParam(required = false) String couponCode,
            @RequestParam(required = false) String couponName,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "50") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return couponService.searchCoupons(couponCode, couponName, pageable);
    }
  
    @GetMapping("/{companyCode}/search")
    public ApiResponse<Page<?>> searchCouponsByCompany(
            @PathVariable String companyCode,
            @RequestParam(required = false) String couponCode,
            @RequestParam(required = false) String couponName,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "50") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return couponService.searchCouponsByCompany(couponCode, couponName, companyCode, pageable);
    }

    @PostMapping("/{companyCode}")
    public ApiResponse<?> createCoupon(@PathVariable String companyCode, @RequestBody CouponDTO coupon) {
        return couponService.createCoupon(coupon, companyCode);
    }

    @PutMapping("/{companyCode}/{couponCode}")
    public ApiResponse<?> updateCoupon(@PathVariable String companyCode, @PathVariable String couponCode,
            @RequestBody CouponDTO coupon) {
        return couponService.updateCoupon(couponCode, companyCode, coupon);
    }

    @DeleteMapping("/{companyCode}/{couponCode}")
    public ApiResponse<?> deleteCoupon(@PathVariable String companyCode, @PathVariable String couponCode) {
        return couponService.deletedCoupon(couponCode, companyCode);
    }
}

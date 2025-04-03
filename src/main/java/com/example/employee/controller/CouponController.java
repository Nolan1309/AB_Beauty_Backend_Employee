package com.example.employee.controller;

import com.example.employee.model.Coupon;
import com.example.employee.service.impl.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "${allowed.origins}", allowCredentials = "true")
@RestController
@RequestMapping( "/api/coupon")
public class CouponController {
    @Autowired
    private CouponService couponService;

    @GetMapping
    public List<Coupon> getAllCoupons() {
        return couponService.getAllCoupon();
    }

    @GetMapping("/{couponCode}")
    public Coupon getCouponById(@PathVariable String couponCode) {
        return couponService.getCouponById(couponCode);
    }

    @PostMapping
    public Coupon createCoupon(@RequestBody Coupon coupon) {
        return couponService.createCoupon(coupon);
    }

    @PutMapping("/{couponCode}")
    public Coupon updateCoupon(@PathVariable String couponCode, @RequestBody Coupon coupon) {
        return couponService.updateCoupon(couponCode, coupon);
    }

    @DeleteMapping("/{couponCode}")
    public void deleteCoupon(@PathVariable String couponCode) {
        couponService.deleteCoupon(couponCode);
    }
}

package com.example.employee.service;

import com.example.employee.model.Coupon;
import com.example.employee.repository.CouponRepository;
import com.example.employee.service.impl.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponServiceImpl implements CouponService {
    @Autowired
    private CouponRepository couponRepository;

    @Override
    public List<Coupon> getAllCoupon() {
        return couponRepository.findAll();
    }

    @Override
    public Coupon getCouponById(String couponCode) {
        return couponRepository.findCouponByCouponCode(couponCode);
    }

    @Override
    public Coupon createCoupon(Coupon coupon) {
        return couponRepository.save(coupon);
    }

    @Override
    public Coupon updateCoupon(String couponCode,Coupon coupon) {
        return couponRepository.save(coupon);
    }

    @Override
    public void deleteCoupon(String couponCode) {
        couponRepository.deleteCouponByCouponCode(couponCode);
    }
}

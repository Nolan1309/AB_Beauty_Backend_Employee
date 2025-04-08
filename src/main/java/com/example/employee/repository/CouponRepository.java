package com.example.employee.repository;

import com.example.employee.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(exported = false)
public interface CouponRepository extends JpaRepository<Coupon,Integer> {
    Coupon findCouponByCouponCode(String couponCode);
    void deleteCouponByCouponCode(String couponCode);
}

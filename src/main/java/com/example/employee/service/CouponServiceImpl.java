package com.example.employee.service;

import com.example.employee.dto.CouponResponseDTO;
import com.example.employee.model.Coupon;
import com.example.employee.repository.CouponRepository;
import com.example.employee.service.impl.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @Override
    public CouponResponseDTO convertToCouponDTO(Coupon coupon) {
        CouponResponseDTO couponDTO = new CouponResponseDTO();
        couponDTO.setId(coupon.getId());
        couponDTO.setCompanyName(coupon.getCompanyName());
        couponDTO.setCouponCode(coupon.getCouponCode());
        couponDTO.setCouponName(coupon.getCouponName());
        couponDTO.setCouponDescription(coupon.getCouponDescription());
        couponDTO.setCouponType(coupon.getCouponType());
        couponDTO.setCouponDateStart(coupon.getCouponDateStart());
        couponDTO.setCouponDateEnd(coupon.getCouponDateEnd());
        couponDTO.setCouponDiscount(coupon.getCouponDiscount());
        couponDTO.setCouponDiscountType(coupon.getCouponDiscountType());
        return couponDTO;
    }

    @Override
    public Page<CouponResponseDTO> getCouponsWithPagination(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Coupon> couponPage = couponRepository.findAll(pageable);

        // Chuyển đổi từ Coupon sang CouponDTO
        return couponPage.map(this::convertToCouponDTO);
    }

}

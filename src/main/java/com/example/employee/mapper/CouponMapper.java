package com.example.employee.mapper;

import com.example.employee.dto.coupon.CouponDTO;
import com.example.employee.model.Coupon;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CouponMapper {
    CouponMapper INSTANCE = Mappers.getMapper(CouponMapper.class);
    
    CouponDTO couponToCouponDTO(Coupon coupon);
    
    Coupon couponDTOToCoupon(CouponDTO couponDTO);
}

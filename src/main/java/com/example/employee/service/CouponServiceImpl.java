package com.example.employee.service;

import com.example.employee.dto.ApiResponse;
import com.example.employee.dto.coupon.CouponDTO;
import com.example.employee.mapper.CouponMapper;
import com.example.employee.mapper.DepartmentMapper;
import com.example.employee.model.Coupon;
import com.example.employee.model.Department;
import com.example.employee.repository.CouponRepository;
import com.example.employee.service.impl.CouponService;
import jakarta.transaction.Transactional;
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

    @Autowired
    private CouponMapper couponMapper;
    @Override
    public ApiResponse<Page<?>> getAllCoupon(Pageable pageable) {
        Page<Coupon> couponPage = couponRepository.findAll(pageable);
        return new ApiResponse<>("Coupon retrieved successfully.", couponPage,200);
    }

    // @Override
    // public ApiResponse<?> getCouponByCouponCode(String couponCode ,String companyCode) {
    //     try{
    //         List<Coupon> couponList = couponRepository.findCouponByCouponCode(couponCode);
    //         if (couponList.isEmpty()){
    //             return new ApiResponse<>("Coupon no found!",null, 404);
    //         }
    //         return new ApiResponse<>("Successful",couponList,200);

    //     }catch (Exception e){
    //         return new ApiResponse<>("Loi he thong",null,500);
    //     }
    // }

    @Override
    @Transactional
    public ApiResponse<?> createCoupon(CouponDTO couponDTO, String companyCode) {
        try {
            Coupon existingCoupon = couponRepository.findCouponByCouponCodeAndCompanyCompanyCode(couponDTO.getCouponCode(),companyCode);
            if (existingCoupon != null) {
                return new ApiResponse<>("Company with code already exists.", null, 400);
            }
            existingCoupon = couponMapper.couponDTOToCoupon(couponDTO);
            Coupon coupon = couponRepository.save(existingCoupon);
            return new ApiResponse<>("Coupon created successfully.", coupon, 200);
        } catch (Exception e) {
            return new ApiResponse<>("Error occurred while creating coupon: " + e.getMessage(), null, 500);
        }
    }

    @Override
    @Transactional
    public  ApiResponse<?>  updateCoupon(String couponCode, String companyCode,CouponDTO couponDTO) {
        Coupon existCoupon = couponRepository.findCouponByCouponCodeAndCompanyCompanyCode(couponCode,companyCode);
        if (existCoupon == null){
            return new ApiResponse<>("Coupon No Found", null,404);
        }
        existCoupon = CouponMapper.INSTANCE.couponDTOToCoupon(couponDTO);
        Coupon couponUpdate =couponRepository.saveAndFlush(existCoupon);
        return new ApiResponse<>("Update successful",couponUpdate,200);
    }

    @Override
    @Transactional
    public ApiResponse<?> deletedCoupon(String couponCode, String companyCode) {
        Coupon coupon = couponRepository.findCouponByCouponCodeAndCompanyCompanyCode(couponCode,companyCode);
        if (coupon== null){
            return new ApiResponse<>("Department No Found",null,404);
        }
        try {
            couponRepository.delete(coupon);
            return new ApiResponse<>("Success",null,200);
        }catch (Exception e){
            return new ApiResponse<>("Loi he thong",null,500);
        }
    }
    
    @Override
    public ApiResponse<Page<?>> searchCoupons(String couponCode, String couponName, Pageable pageable) {
        try {
            Page<Coupon> couponPage = couponRepository.findBySearchCriteria(couponCode, couponName, pageable);
            return ApiResponse.success("Coupons found successfully", couponPage);
        } catch (Exception e) {
            return ApiResponse.error("Error searching coupons: " + e.getMessage(), 500);
        }
    }
    
    @Override
    public ApiResponse<Page<?>> searchCouponsByCompany(String couponCode, String couponName, String companyCode, Pageable pageable) {
        try {
            Page<Coupon> couponPage = couponRepository.findBySearchCriteriaAndCompany(couponCode, couponName, companyCode, pageable);
            return ApiResponse.success("Coupons found successfully", couponPage);
        } catch (Exception e) {
            return ApiResponse.error("Error searching coupons: " + e.getMessage(), 500);
        }
    }

//    @Override
//    public CouponDTO convertToCouponDTO(Coupon coupon) {
//        CouponDTO couponDTO = new CouponDTO();
//        couponDTO.setId(coupon.getId());
//        couponDTO.setCompanyName(coupon.getCompanyName());
//        couponDTO.setCouponCode(coupon.getCouponCode());
//        couponDTO.setCouponName(coupon.getCouponName());
//        couponDTO.setCouponDescription(coupon.getCouponDescription());
//        couponDTO.setCouponType(coupon.getCouponType());
//        couponDTO.setCouponDateStart(coupon.getCouponDateStart());
//        couponDTO.setCouponDateEnd(coupon.getCouponDateEnd());
//        couponDTO.setCouponDiscount(coupon.getCouponDiscount());
//        couponDTO.setCouponDiscountType(coupon.getCouponDiscountType());
//        return couponDTO;
//    }

//    @Override
//    public Page<CouponDTO> getCouponsWithPagination(int page, int size) {
//        Pageable pageable = PageRequest.of(page, size);
//        Page<Coupon> couponPage = couponRepository.findAll(pageable);
//
//        // Chuyển đổi từ Coupon sang CouponDTO
//        return couponPage.map(this::convertToCouponDTO);
//    }

}

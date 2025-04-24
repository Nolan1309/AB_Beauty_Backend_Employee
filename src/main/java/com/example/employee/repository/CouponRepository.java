package com.example.employee.repository;

import com.example.employee.model.Coupon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource(exported = false)
public interface CouponRepository extends JpaRepository<Coupon, Integer> {
    // Coupon findCouponByCouponCode(String couponCode);
    Coupon findCouponByCouponCodeAndCompanyCompanyCode(String couponCode, String companyCode);

    List<Coupon> findCouponByCouponCode(String couponCode);
    // void deleteCouponByCouponCode(String couponCode);
    
    /**
     * Tìm kiếm coupon theo mã khuyến mãi hoặc tên khuyến mãi
     * @param couponCode mã khuyến mãi (có thể null)
     * @param couponName tên khuyến mãi (có thể null)
     * @param pageable thông tin phân trang
     * @return Page<Coupon> kết quả phân trang
     */
    @Query("SELECT c FROM Coupon c WHERE " +
           "(:couponCode IS NULL OR LOWER(c.couponCode) LIKE LOWER(CONCAT('%', :couponCode, '%'))) AND " +
           "(:couponName IS NULL OR LOWER(c.couponName) LIKE LOWER(CONCAT('%', :couponName, '%')))")
    Page<Coupon> findBySearchCriteria(
        @Param("couponCode") String couponCode,
        @Param("couponName") String couponName,
        Pageable pageable
    );
    
    /**
     * Tìm kiếm coupon theo mã khuyến mãi, tên khuyến mãi và mã công ty
     * @param couponCode mã khuyến mãi (có thể null)
     * @param couponName tên khuyến mãi (có thể null)
     * @param companyCode mã công ty
     * @param pageable thông tin phân trang
     * @return Page<Coupon> kết quả phân trang
     */
    @Query("SELECT c FROM Coupon c WHERE " +
           "c.company.companyCode = :companyCode AND " +
           "(:couponCode IS NULL OR LOWER(c.couponCode) LIKE LOWER(CONCAT('%', :couponCode, '%'))) AND " +
           "(:couponName IS NULL OR LOWER(c.couponName) LIKE LOWER(CONCAT('%', :couponName, '%')))")
    Page<Coupon> findBySearchCriteriaAndCompany(
        @Param("couponCode") String couponCode,
        @Param("couponName") String couponName,
        @Param("companyCode") String companyCode,
        Pageable pageable
    );
}

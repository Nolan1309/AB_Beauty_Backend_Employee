package com.example.employee.config;

/**
 * Class chứa tất cả các endpoint API của ứng dụng,
 * được tổ chức theo phương thức HTTP và quyền truy cập
 */
public class Endpoint {
    /**
     * Các API có thể truy cập mà không cần xác thực
     */
    public static final String[] PUBLIC_GET_ENDPOINT = {
        // Auth endpoints
        "/api/auth/refresh-token"
    };

    public static final String[] PUBLIC_POST_ENDPOINT = {
        // Auth endpoints
        "/api/auth/login",
        "/api/auth/register"
    };

    public static final String[] PUBLIC_PUT_ENDPOINT = {
        // Không có endpoint public PUT
    };

    public static final String[] PUBLIC_DELETE_ENDPOINT = {
        // Không có endpoint public DELETE
    };

    /**
     * Các API chỉ ADMIN mới có thể truy cập
     */
    public static final String[] ADMIN_GET_ENDPOINT = {
        // Company endpoints
        "/api/company",
        "/api/company/**",

        // Employee endpoints
        "/api/employee",
        "/api/employee/**",

        // Department endpoints
        "/api/department",
        "/api/department/**",
        
        // Coupon endpoints
        "/api/coupon",
        "/api/coupon/search",
        
        // Info Employee endpoints
        "/api/info-employee",
        "/api/info-employee/**",
        
        // Salary endpoints
        "/api/salary",
        "/api/salary/**"
    };

    public static final String[] ADMIN_POST_ENDPOINT = {
        // Company endpoints
        "/api/company",
        
        // Employee endpoints
        "/api/employee",
        
        // Department endpoints
        "/api/department",
        
        // Coupon endpoints
        "/api/coupon",
        
        // Info Employee endpoints
        "/api/info-employee",
        
        // Salary endpoints
        "/api/salary"
    };

    public static final String[] ADMIN_PUT_ENDPOINT = {
        // Company endpoints
        "/api/company/**",
        
        // Employee endpoints
        "/api/employee/**",
        
        // Department endpoints
        "/api/department/**",
        
        // Coupon endpoints
        "/api/coupon/**",
        
        // Info Employee endpoints
        "/api/info-employee/**",
        
        // Salary endpoints
        "/api/salary/**"
    };

    public static final String[] ADMIN_DELETE_ENDPOINT = {
        // Company endpoints
        "/api/company/**",
        
        // Employee endpoints
        "/api/employee/**",
        
        // Department endpoints
        "/api/department/**",
        
        // Coupon endpoints
        "/api/coupon/**",
        
        // Info Employee endpoints
        "/api/info-employee/**",
        
        // Salary endpoints
        "/api/salary/**"
    };

    /**
     * Các API mà USER có thể truy cập
     */
    public static final String[] USER_GET_ENDPOINT = {
        // Company endpoints (chỉ xem công ty của mình)
        "/api/company/*",
            "/api/company/list",
        // Coupon endpoints
        "/api/coupon",
        "/api/coupon/*/search",

        // Department endpoints
        "/api/department",
        "/api/department/*",
        "/api/department/company/*",
        
        // Employee endpoints
        "/api/employee/*",
        "/api/employee/same-company",
        
        // Info Employee endpoints (chỉ xem thông tin của mình)
        "/api/info-employee/*",
        
        // Salary endpoints (chỉ xem thông tin lương của mình)
        "/api/salary/*/employee/*",
        "/api/salary/employee/*/salary/*"
    };

    public static final String[] USER_POST_ENDPOINT = {
        // Info Employee endpoints (chỉ tạo thông tin cho mình)
        "/api/info-employee/*",
        
        // Auth endpoints
        "/api/auth/logout",
            "/api/info-employee"
    };

    public static final String[] USER_PUT_ENDPOINT = {
        // Info Employee endpoints (chỉ cập nhật thông tin của mình)
        "/api/info-employee/*",
            "/api/info-employee/**",
            "/api/employee/*/change-password"
    };
    
    public static final String[] USER_DELETE_ENDPOINT = {
        // Không có endpoint USER DELETE
    };
}

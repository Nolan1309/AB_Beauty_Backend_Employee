package com.example.employee.config;

import org.springframework.beans.factory.annotation.Value;

public class Endpoint {
    public static final String[] PUBLIC_GET_ENDPOINT = {
            "/api/auth/refresh-token",
    };
    public static final String[] PUBLIC_POST_ENDPOINT = {
            "/api/auth/register",
            "/api/auth/login",
    };
    public static final String[] PUBLIC_PUT_ENDPOINT = {

    };

    public static final String[] PUBLIC_DELETE_ENDPOINT = {

    };

    public static final String[] ADMIN_GET_ENDPOINT = {
            "/api/company",
            "/api/info-employee",
    };
    public static final String[] ADMIN_POST_ENDPOINT = {

    };
    public static final String[] ADMIN_DELETE_ENDPOINT = {

    };
    public static final String[] ADMIN_PUT_ENDPOINT = {

    };


    public static final String[] USER_GET_ENDPOINT = {
            "/api/company/*",
            "/api/coupon",
            "/api/coupon/*",
            "/api/department",
            "/api/department/*",
            "/api/employee",
            "/api/employee/*",
            "/api/info-employee/*",
            "/api/coupon/page",
            "/api/salary/*/employee/*",
            "/api/employee/*/same-company",
            "/api/salary/employee/*/salary/*"
    };

    public static final String[] USER_POST_ENDPOINT = {
            "/api/info-employee/*"
    };

    public static final String[] USER_PUT_ENDPOINT = {


    };
    public static final String[] USER_DELETE_ENDPOINT = {

    };


}

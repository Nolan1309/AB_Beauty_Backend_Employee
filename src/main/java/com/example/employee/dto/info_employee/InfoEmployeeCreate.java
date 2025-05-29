package com.example.employee.dto.info_employee;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class InfoEmployeeCreate {
//    Mã nhân viên
    private String employeeCode;

    private String image;
//    ID nhân viên
    private String employeeId;
//    Ngày vào làm
    private Date hireDate;
//    Mã công ty
    private String companyCode;
//    Họ và tên nhân viên
    private String fullname;
//    Ngày sinh nhân viên
    private Date dob;
//    Tình trạng hôn nhân
    private String maritalStatus;
//    Email
    private String email;
//    Điện thoại
    private String phone;
//    Địa chỉ thường trú
    private String permanentAddress;
//    Địa chỉ liên hệ
    private String contactAddress;
//    Tôn giáo
    private String religion;
//    Dân tộc
    private String ethnicity;
//    Quốc tịch
    private String nationality;
//    Trình độ văn hóa
    private String education;
//    Số CMND/ Hộ chiếu
    private String idCard;
//    Ngày cấp
    private Date issueDate;
//    Nơi cấp
    private String issuePlace;
//    Tên ngân hàng
    private String bankName;
//    Tên tài khoản
    private String accountName;
//    Số tài khoản
    private String accountNumber;
//    Số sổ BHXH
    private String socialInsuranceNumber;
//    Chức vụ
    private String position;
}

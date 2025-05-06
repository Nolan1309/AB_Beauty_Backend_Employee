package com.example.employee.dto.info_employee;

import com.example.employee.dto.auth.LoginResponse;
import lombok.Data;

import java.util.Date;
@Data
public class InfoEmployeeRequest {
    private String employeeCode;
    private String employeeId;
    private Date infoStartDate;
    private String companyCode;
    private String infoMarry;
    private String infoEmail;
    private String infoPhone;
    private String infoAddressPermanent;
    private String infoAddressContact;
    private String infoReligion;
    private String infoNation;
    private String infoNationality;
    private String infoCulturalLevel;
    private String infoCitizenshipIdentity;
    private String infoPlaceDate;
    private String infoNameBank;
    private String infoNameEmployeeBank;
    private String infoNumberBank;
    private String infoMedicalDanger;
}

package com.example.employee.dto;

import lombok.Data;

import java.util.Date;
@Data
public class InfoEmployeePublicDTO {
    private String employeeCode;
    private String employeeName;
    private String employeePhone;
    private String infoNameBank;
    private String infoNameEmployeeBank;
    private String infoCulturalLevel;
    private Date infoStartDate;
    private String infoAddressPermanent;
    private String infoAddressContact;
    private String departmentCode;
    private String departmentName;

    public InfoEmployeePublicDTO(String employeeCode, String employeeName, String employeePhone, String infoNameBank, String infoNameEmployeeBank, String infoCulturalLevel, Date infoStartDate, String infoAddressPermanent, String infoAddressContact, String departmentCode, String departmentName) {
        this.employeeCode = employeeCode;
        this.employeeName = employeeName;
        this.employeePhone = employeePhone;
        this.infoNameBank = infoNameBank;
        this.infoNameEmployeeBank = infoNameEmployeeBank;
        this.infoCulturalLevel = infoCulturalLevel;
        this.infoStartDate = infoStartDate;
        this.infoAddressPermanent = infoAddressPermanent;
        this.infoAddressContact = infoAddressContact;
        this.departmentCode = departmentCode;
        this.departmentName = departmentName;
    }

    public InfoEmployeePublicDTO() {
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getInfoNameBank() {
        return infoNameBank;
    }

    public void setInfoNameBank(String infoNameBank) {
        this.infoNameBank = infoNameBank;
    }

    public String getInfoNameEmployeeBank() {
        return infoNameEmployeeBank;
    }

    public void setInfoNameEmployeeBank(String infoNameEmployeeBank) {
        this.infoNameEmployeeBank = infoNameEmployeeBank;
    }

    public String getInfoCulturalLevel() {
        return infoCulturalLevel;
    }

    public void setInfoCulturalLevel(String infoCulturalLevel) {
        this.infoCulturalLevel = infoCulturalLevel;
    }

    public Date getInfoStartDate() {
        return infoStartDate;
    }

    public void setInfoStartDate(Date infoStartDate) {
        this.infoStartDate = infoStartDate;
    }

    public String getInfoAddressPermanent() {
        return infoAddressPermanent;
    }

    public void setInfoAddressPermanent(String infoAddressPermanent) {
        this.infoAddressPermanent = infoAddressPermanent;
    }

    public String getInfoAddressContact() {
        return infoAddressContact;
    }

    public void setInfoAddressContact(String infoAddressContact) {
        this.infoAddressContact = infoAddressContact;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}

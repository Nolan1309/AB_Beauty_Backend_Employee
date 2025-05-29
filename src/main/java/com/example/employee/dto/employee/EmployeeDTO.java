package com.example.employee.dto.employee;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class EmployeeDTO {
    private Integer id;
    private String employeeCode;
    private String employeeName;
    private String image;
    private String email;
    private String password;
    private String employeePhoneNumber;
    private Date employeeLastLogin;
    private Short employeeActive;
    private String companyCode;
    private String companyName;

    private BigDecimal employeeTotalLTL = BigDecimal.ZERO;
    private BigDecimal employeeTotalLKF = BigDecimal.ZERO;
    private BigDecimal employeeTotalLKF_M = BigDecimal.ZERO;
    private BigDecimal employeeTotalLDL = BigDecimal.ZERO;
    private BigDecimal employeeTotalABD = BigDecimal.ZERO;
    private BigDecimal employeeTotalABT = BigDecimal.ZERO;
    private BigDecimal employeeTotalABBW = BigDecimal.ZERO;
    private BigDecimal employeeTotalABBW_ABB = BigDecimal.ZERO;
    private BigDecimal employeeTotalAffiliate = BigDecimal.ZERO;
    private BigDecimal employeeBalance = BigDecimal.ZERO;
    private BigDecimal employeeTotalWithdraw = BigDecimal.ZERO;

    // Department information
    private String departmentCode;

    // Role information
    private Integer roleId;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmployeePhoneNumber() {
        return employeePhoneNumber;
    }

    public void setEmployeePhoneNumber(String employeePhoneNumber) {
        this.employeePhoneNumber = employeePhoneNumber;
    }

    public Date getEmployeeLastLogin() {
        return employeeLastLogin;
    }

    public void setEmployeeLastLogin(Date employeeLastLogin) {
        this.employeeLastLogin = employeeLastLogin;
    }

    public Short getEmployeeActive() {
        return employeeActive;
    }

    public void setEmployeeActive(Short employeeActive) {
        this.employeeActive = employeeActive;
    }

    public BigDecimal getEmployeeTotalLTL() {
        return employeeTotalLTL;
    }

    public void setEmployeeTotalLTL(BigDecimal employeeTotalLTL) {
        this.employeeTotalLTL = employeeTotalLTL;
    }

    public BigDecimal getEmployeeTotalLKF() {
        return employeeTotalLKF;
    }

    public void setEmployeeTotalLKF(BigDecimal employeeTotalLKF) {
        this.employeeTotalLKF = employeeTotalLKF;
    }

    public BigDecimal getEmployeeTotalLKF_M() {
        return employeeTotalLKF_M;
    }

    public void setEmployeeTotalLKF_M(BigDecimal employeeTotalLKF_M) {
        this.employeeTotalLKF_M = employeeTotalLKF_M;
    }

    public BigDecimal getEmployeeTotalLDL() {
        return employeeTotalLDL;
    }

    public void setEmployeeTotalLDL(BigDecimal employeeTotalLDL) {
        this.employeeTotalLDL = employeeTotalLDL;
    }

    public BigDecimal getEmployeeTotalABD() {
        return employeeTotalABD;
    }

    public void setEmployeeTotalABD(BigDecimal employeeTotalABD) {
        this.employeeTotalABD = employeeTotalABD;
    }

    public BigDecimal getEmployeeTotalABT() {
        return employeeTotalABT;
    }

    public void setEmployeeTotalABT(BigDecimal employeeTotalABT) {
        this.employeeTotalABT = employeeTotalABT;
    }

    public BigDecimal getEmployeeTotalABBW() {
        return employeeTotalABBW;
    }

    public void setEmployeeTotalABBW(BigDecimal employeeTotalABBW) {
        this.employeeTotalABBW = employeeTotalABBW;
    }

    public BigDecimal getEmployeeTotalABBW_ABB() {
        return employeeTotalABBW_ABB;
    }

    public void setEmployeeTotalABBW_ABB(BigDecimal employeeTotalABBW_ABB) {
        this.employeeTotalABBW_ABB = employeeTotalABBW_ABB;
    }

    public BigDecimal getEmployeeTotalAffiliate() {
        return employeeTotalAffiliate;
    }

    public void setEmployeeTotalAffiliate(BigDecimal employeeTotalAffiliate) {
        this.employeeTotalAffiliate = employeeTotalAffiliate;
    }

    public BigDecimal getEmployeeBalance() {
        return employeeBalance;
    }

    public void setEmployeeBalance(BigDecimal employeeBalance) {
        this.employeeBalance = employeeBalance;
    }

    public BigDecimal getEmployeeTotalWithdraw() {
        return employeeTotalWithdraw;
    }

    public void setEmployeeTotalWithdraw(BigDecimal employeeTotalWithdraw) {
        this.employeeTotalWithdraw = employeeTotalWithdraw;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}

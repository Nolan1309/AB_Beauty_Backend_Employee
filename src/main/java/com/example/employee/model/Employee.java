package com.example.employee.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

@Data
@Entity
@Table(name = "employee")
public class Employee implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Getter
    @ManyToOne
    @JoinColumn(name = "role_id")
    @JsonIgnore
    private Role role;

    @Column(name = "password")
    private String password;

    @Column(name = "employee_code",length = 200, nullable = false, unique = true)
    private String employeeCode;

    @Column(name = "employee_name", nullable = false)
    private String employeeName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "employee_phone")
    private String employeePhoneNumber;

    @Temporal(TemporalType.DATE)
    @Column(name = "employee_last_login")
    private Date employeeLastLogin;

    @Column(name = "employee_active")
    private Short employeeActive;

    @Column(name = "employee_total_LTL",precision = 65)
    private BigDecimal employeeTotalLTL = BigDecimal.ZERO;

    @Column(name = "employee_total_LKF",precision = 65)
    private BigDecimal employeeTotalLKF = BigDecimal.ZERO;

    @Column(name = "employee_total_LKF_M",precision = 65)
    private BigDecimal employeeTotalLKF_M = BigDecimal.ZERO;

    @Column(name = "employee_total_LDL",precision = 65)
    private BigDecimal employeeTotalLDL = BigDecimal.ZERO;

    @Column(name = "employee_total_ABD",precision = 65)
    private BigDecimal employeeTotalABD = BigDecimal.ZERO;

    @Column(name = "employee_total_ABT",precision = 65)
    private BigDecimal employeeTotalABT = BigDecimal.ZERO;

    @Column(name = "employee_total_ABBW",precision = 65)
    private BigDecimal employeeTotalABBW = BigDecimal.ZERO;

    @Column(name = "employee_total_ABBW_ABB",precision = 65)
    private BigDecimal employeeTotalABBW_ABB = BigDecimal.ZERO;

    @Column(name = "employee_total_Affiliate",precision = 65)
    private BigDecimal employeeTotalAffiliate = BigDecimal.ZERO;

    @Column(name = "employee_banlance",precision = 65)
    private BigDecimal employeeBalance = BigDecimal.ZERO;

    @Column(name = "employee_total_Withdrat",precision = 65)
    private BigDecimal employeeTotalWithdraw = BigDecimal.ZERO;

    @ManyToOne
    @JoinColumn(name = "department_code", referencedColumnName = "department_code")
    private Department department;

    public void setRole(Role role) {
        this.role = role;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.email = employeeEmail;
    }
    public String getEmployeeEmail() {
        return email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Here you should return the authorities/roles assigned to the employee
        // For example, assuming that the Role entity has a collection of authorities
        return Arrays.asList(new SimpleGrantedAuthority(role.getName())); // Adjust this based on your Role class
    }

    @Override
    public String getPassword() {
        return password;  // Returning the password for authentication
    }

    @Override
    public String getUsername() {
        return email;  // Usually, the username is the email
    }
    public Role getRole() {
        return role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}

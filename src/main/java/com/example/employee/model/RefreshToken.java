package com.example.employee.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;
import java.util.Date;
@Data
@Entity
@Table(name = "refresh_token")
public class RefreshToken {
    private static final int EXPIRATION = 60 * 24;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "token", nullable = false, unique = true, length = 255)
    private String token;

    @ManyToOne()
    @JoinColumn(name = "employee_code", referencedColumnName = "employee_code",nullable = false)
    private Employee employee;


    @Column(name = "expiryDate", nullable = false)
    private Instant expiryDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Instant getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Instant expiryDate) {
        this.expiryDate = expiryDate;
    }
}

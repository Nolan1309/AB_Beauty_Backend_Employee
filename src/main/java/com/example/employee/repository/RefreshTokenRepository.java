package com.example.employee.repository;

import com.example.employee.model.Employee;
import com.example.employee.model.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RepositoryRestResource(exported = false)
public interface RefreshTokenRepository extends JpaRepository<RefreshToken,Integer> {
    Optional<RefreshToken> findByToken(String token);
    Optional<RefreshToken> findRefreshTokenByEmployeeEmployeeCode(String employeeCode);
}

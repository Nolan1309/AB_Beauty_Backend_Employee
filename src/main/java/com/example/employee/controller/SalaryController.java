package com.example.employee.controller;

import com.example.employee.config.JwtService;
import com.example.employee.dto.ApiResponse;
import com.example.employee.dto.salary.SalaryResponseDTO;
import com.example.employee.model.Salary;
import com.example.employee.service.impl.SalaryService;
import com.example.employee.util.AccessControlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salary")
public class SalaryController {
    @Autowired
    private SalaryService salaryService;

    @Autowired
    private AccessControlUtil accessControlUtil;

    @Autowired
    private JwtService jwtService;

    @GetMapping
    public List<Salary> getAllSalaries() {
        return salaryService.getAllSalary();
    }

    @GetMapping("/{salaryId}/employee/{employeeCode}")
    public ResponseEntity<?> getSalaryByEmployeeCodeAndId(@PathVariable String employeeCode,
            @PathVariable Integer salaryId, @RequestHeader("Authorization") String token) {
        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        String emailFromToken = jwtService.extractUsername(token);
        boolean check = accessControlUtil.canAccessEmployeeInfo(employeeCode, emailFromToken);
        if (!check) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access Denied");
        }
        SalaryResponseDTO salaryResponseDTO = salaryService.getSalaryByEmployeeCode(employeeCode, salaryId);
        if (salaryResponseDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Salary record not found.");
        }
        return ResponseEntity.ok(salaryResponseDTO);
    }

    @GetMapping("/employee/{employeeCode}/salary/{year}")
    public ResponseEntity<ApiResponse<?>> getSalariesByYear(
            @PathVariable String employeeCode,
            @PathVariable int year,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "6") int size,
            @RequestHeader("Authorization") String token) {

        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        String emailFromToken = jwtService.extractUsername(token);
        boolean check = accessControlUtil.canAccessEmployeeInfo(employeeCode, emailFromToken);
        if (!check) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ApiResponse<>("Access Denied", null, 403));
        }
        Page<SalaryResponseDTO> salaryPage = salaryService.getSalariesByEmployeeCodeAndYear(employeeCode, year, page, size);
        if (salaryPage.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>("No salary data found for this employee in the given year.", null, 404));
        }
        return ResponseEntity.ok(new ApiResponse<>("Salaries retrieved successfully.", salaryPage, 200));
    }


    @PostMapping
    public Salary createSalary(@RequestBody Salary salary) {
        return salaryService.createSalary(salary);
    }

    @PutMapping("/{employeeCode}")
    public Salary updateSalary(@PathVariable String employeeCode, @RequestBody Salary salary) {
        return salaryService.updateSalary(employeeCode, salary);
    }

    @DeleteMapping("/{employeeCode}")
    public void deleteSalary(@PathVariable String employeeCode) {
        salaryService.deleteSalary(employeeCode);
    }
}

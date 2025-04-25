package com.example.employee.controller;

import com.example.employee.config.JwtService;
import com.example.employee.dto.ApiResponse;
import com.example.employee.dto.employee.EmployeeDTO;
import com.example.employee.model.Employee;
import com.example.employee.service.impl.EmployeeService;
import com.example.employee.util.AccessControlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private AccessControlUtil accessControlUtil;

    @Autowired
    private JwtService jwtService;

    @GetMapping
    public ApiResponse<Page<?>> getAllEmployees(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "50") int size) {
        Pageable pageable;
        pageable = PageRequest.of(page, size);
        return employeeService.getAllEmployee(pageable);
    }

    
    @GetMapping("/same-company")
    public ApiResponse<Page<?>> getColleagues(
            @RequestHeader("Authorization") String token,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "50") int size) {
        if (token == null || !token.startsWith("Bearer ")) {
            return ApiResponse.error("Invalid or missing token.", 400);
        }
        
        // Extract token
        String jwtToken = token.substring(7);
        String email = jwtService.extractUsername(jwtToken);
        
        // Get employee from email
        Employee employee = employeeService.getEmployeeByEmail(email);
        if (employee == null) {
            return ApiResponse.error("Employee not found for the authenticated user.", 404);
        }
        
        // Get colleagues
        Pageable pageable = PageRequest.of(page, size);
        Page<Employee> colleagues = employeeService.getEmployeesInSameCompany(employee.getEmployeeCode(), pageable);
        
        return ApiResponse.success("Retrieved colleagues successfully", colleagues);
    }

    @GetMapping("/{employeeCode}")
    public ApiResponse<?> getEmployeeByEmployeeCode(@PathVariable String employeeCode,
            @RequestHeader("Authorization") String token) {
        if (token == null || !token.startsWith("Bearer ")) {
            return ApiResponse.error("Invalid or missing token.", 400);
        }
        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        String emailFromToken = jwtService.extractUsername(token);
        boolean check = accessControlUtil.canAccessEmployeeInfo(employeeCode, emailFromToken);
        if (!check) {
            return ApiResponse.error("Access Denied.", 403);
        }
        return employeeService.getEmployeeByEmployeeCode(employeeCode);
    }

    @PostMapping
    public ApiResponse<?> createEmployee(@RequestBody EmployeeDTO employee) {
        return employeeService.createEmployee(employee);
    }

    @PutMapping("/{employeeCode}")
    public ApiResponse<?> updateEmployee(@PathVariable String employeeCode, @RequestBody EmployeeDTO employee,
            @RequestHeader("Authorization") String token) {
        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        String emailFromToken = jwtService.extractUsername(token);
        boolean check = accessControlUtil.canAccessEmployeeInfo(employeeCode, emailFromToken);
        if (!check) {
            return ApiResponse.error("Access Denied", 403);
        }
        return employeeService.updateEmployee(employeeCode, employee);
    }

    @DeleteMapping("/{employeeCode}")
    public ApiResponse<?> deleteEmployee(@PathVariable String employeeCode) {
        return employeeService.deletedEmployee(employeeCode);
    }
}

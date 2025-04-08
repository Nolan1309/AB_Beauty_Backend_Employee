package com.example.employee.controller;

import com.example.employee.config.JwtService;
import com.example.employee.model.Employee;
import com.example.employee.service.impl.EmployeeService;
import com.example.employee.util.AccessControlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "${allowed.origins}", allowCredentials = "true")
@RestController
@RequestMapping( "/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private AccessControlUtil accessControlUtil;

    @Autowired
    private JwtService jwtService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/{employeeCode}/same-company")
    public Page<Employee> getEmployeesInSameCompany(
            @PathVariable String employeeCode,
            @RequestParam int page,
            @RequestParam int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return employeeService.getEmployeesInSameCompany(employeeCode, pageable);
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/{employeeCode}")
    public ResponseEntity<?> getEmployeeByEmployeeCode(@PathVariable String employeeCode, @RequestHeader("Authorization") String token) {

        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        String emailFromToken = jwtService.extractUsername(token);
        boolean check = accessControlUtil.canAccessEmployeeInfo(employeeCode, emailFromToken);
        if (!check) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access Denied");
        }
        Employee employee = employeeService.getEmployeeById(employeeCode);
        return ResponseEntity.ok(employee);
    }


    @PutMapping("/{employeeCode}")
    public ResponseEntity<Object> updateEmployee(@PathVariable String employeeCode, @RequestBody Employee employee, @RequestHeader("Authorization") String token) {
        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        String emailFromToken = jwtService.extractUsername(token);
        boolean check = accessControlUtil.canAccessEmployeeInfo(employeeCode, emailFromToken);
        if (!check) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access Denied");  // Trả về mã lỗi 403 nếu không có quyền
        }
        Employee updatedEmployee = employeeService.updateEmployee(employeeCode, employee);
        return ResponseEntity.ok(updatedEmployee);
    }


    @DeleteMapping("/{employeeCode}")
    public void deleteEmployee(@PathVariable String employeeCode) {
        employeeService.deleteEmployee(employeeCode);
    }
}

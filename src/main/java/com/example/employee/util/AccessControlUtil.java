package com.example.employee.util;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.service.impl.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccessControlUtil {

    @Autowired
    private EmployeeService employeeService;

    public  boolean canAccessEmployeeInfo(String requestedEmployeeCode, String emailFromToken) {
        Employee employee = employeeService.getEmployeeByEmail(emailFromToken);
        if (employee == null) {
            return false;
        }
        return employee.getEmployeeCode().equals(requestedEmployeeCode) || employee.getRole().getName().equals("ADMIN");
    }
}

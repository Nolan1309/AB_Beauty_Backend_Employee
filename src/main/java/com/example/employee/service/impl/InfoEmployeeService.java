package com.example.employee.service.impl;

import com.example.employee.model.InfoEmployee;

import java.util.List;

public interface InfoEmployeeService {
    List<InfoEmployee> getAllInfoEmployee();
    InfoEmployee getInfoEmployeeById(String employeeCode);

    InfoEmployee createInfoEmployee(InfoEmployee infoEmployee);
    InfoEmployee updateInfoEmployee(String employeeCode,InfoEmployee infoEmployee);
    void deleteInfoEmployee(String employeeCode);
}

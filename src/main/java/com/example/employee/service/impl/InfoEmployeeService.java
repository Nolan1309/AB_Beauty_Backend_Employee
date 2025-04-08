package com.example.employee.service.impl;

import com.example.employee.dto.InfoEmployeePublicDTO;
import com.example.employee.model.InfoEmployee;

import java.util.List;

public interface InfoEmployeeService {
    List<InfoEmployee> getAllInfoEmployee();
    InfoEmployee getInfoEmployeeByEmployeeCode(String employeeCode);

    InfoEmployee createInfoEmployee(InfoEmployee infoEmployee);
    InfoEmployee updateInfoEmployee(String employeeCode,InfoEmployee infoEmployee);
    void deleteInfoEmployee(String employeeCode);
    InfoEmployeePublicDTO getPublicEmployeeInfo(String employeeCode);

}

package com.example.employee.service.impl;

import com.example.employee.dto.ApiResponse;
import com.example.employee.dto.info_employee.InfoEmployeeCreate;
import com.example.employee.dto.info_employee.InfoEmployeePublicDTO;
import com.example.employee.dto.info_employee.InfoEmployeeRequest;
import com.example.employee.model.InfoEmployee;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface InfoEmployeeService {
    List<InfoEmployee> getAllInfoEmployee();
    ApiResponse<?> getInfoEmployeeByEmployeeCode(String employeeCode);
    ApiResponse<?> createInfoEmployee(InfoEmployeeCreate infoEmployeeRequest, String employeeImages);
    ApiResponse<?> updateInfoEmployee(String employeeCode, InfoEmployeeCreate infoEmployeeRequest);
    void deleteInfoEmployee(String employeeCode);
    InfoEmployeePublicDTO getPublicEmployeeInfo(String employeeCode);

}

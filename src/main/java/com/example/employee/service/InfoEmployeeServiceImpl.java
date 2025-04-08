package com.example.employee.service;

import com.example.employee.dto.InfoEmployeePublicDTO;
import com.example.employee.model.InfoEmployee;
import com.example.employee.repository.InfoEmployeeRepository;
import com.example.employee.service.impl.InfoEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoEmployeeServiceImpl implements InfoEmployeeService {

    @Autowired
    private InfoEmployeeRepository infoEmployeeRepository;
    @Override
    @Lazy
    public List<InfoEmployee> getAllInfoEmployee() {
        return infoEmployeeRepository.findAll();
    }

    @Override
    public InfoEmployee getInfoEmployeeByEmployeeCode(String employeeCode) {
        return infoEmployeeRepository.findInfoEmployeeByEmployeeEmployeeCode(employeeCode);
    }

    @Override
    public InfoEmployee createInfoEmployee(InfoEmployee infoEmployee) {
        return null;
    }

    @Override
    public InfoEmployee updateInfoEmployee(String employeeCode,InfoEmployee infoEmployee) {
        return null;
    }

    @Override
    public void deleteInfoEmployee(String employeeCode) {

    }

    @Override
    public InfoEmployeePublicDTO getPublicEmployeeInfo(String employeeCode) {
        return infoEmployeeRepository.findPublicEmployeeInfoByCode(employeeCode);
    }
}

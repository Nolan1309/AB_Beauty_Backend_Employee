package com.example.employee.service;

import com.example.employee.model.InfoEmployee;
import com.example.employee.service.impl.InfoEmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoEmployeeServiceImpl implements InfoEmployeeService {
    @Override
    public List<InfoEmployee> getAllInfoEmployee() {
        return null;
    }

    @Override
    public InfoEmployee getInfoEmployeeById(String employeeCode) {
        return null;
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
}

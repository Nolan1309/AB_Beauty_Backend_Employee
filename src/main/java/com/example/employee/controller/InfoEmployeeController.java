package com.example.employee.controller;

import com.example.employee.dto.info_employee.InfoEmployeePublicDTO;
import com.example.employee.model.InfoEmployee;
import com.example.employee.service.impl.InfoEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/api/info-employee")
public class InfoEmployeeController {

    @Autowired
    private InfoEmployeeService infoEmployeeService;


    @GetMapping("/{employeeCode}")
    public InfoEmployeePublicDTO getPublicEmployeeInfo(@PathVariable String employeeCode) {
        return infoEmployeeService.getPublicEmployeeInfo(employeeCode);
    }

    @PostMapping
    public InfoEmployee createInfoEmployee(@RequestBody InfoEmployee infoEmployee) {
        return infoEmployeeService.createInfoEmployee(infoEmployee);
    }

    @PutMapping("/{employeeCode}")
    public InfoEmployee updateInfoEmployee(@PathVariable String employeeCode, @RequestBody InfoEmployee infoEmployee) {
        return infoEmployeeService.updateInfoEmployee(employeeCode, infoEmployee);
    }

    @DeleteMapping("/{employeeCode}")
    public void deleteInfoEmployee(@PathVariable String employeeCode) {
        infoEmployeeService.deleteInfoEmployee(employeeCode);
    }
}

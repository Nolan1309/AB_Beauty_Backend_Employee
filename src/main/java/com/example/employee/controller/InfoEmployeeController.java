package com.example.employee.controller;

import com.example.employee.dto.ApiResponse;
import com.example.employee.dto.info_employee.InfoEmployeeCreate;
import com.example.employee.dto.info_employee.InfoEmployeePublicDTO;
import com.example.employee.dto.info_employee.InfoEmployeeRequest;
import com.example.employee.model.Employee;
import com.example.employee.model.InfoEmployee;
import com.example.employee.service.impl.EmployeeService;
import com.example.employee.service.impl.InfoEmployeeService;
import com.example.employee.util.ImageKitService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.imagekit.sdk.exceptions.*;
import io.imagekit.sdk.models.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;


@RestController
@RequestMapping( "/api/info-employee")
public class InfoEmployeeController {

    @Autowired
    private InfoEmployeeService infoEmployeeService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ImageKitService imageKitService;


    @GetMapping("/{employeeCode}")
    public ApiResponse<?> getInfoEmployeeByEmployeeCode(@PathVariable String employeeCode) {
        return infoEmployeeService.getInfoEmployeeByEmployeeCode(employeeCode);
    }

    @PostMapping
    public ApiResponse<?> createInfoEmployee(
            @RequestParam("employeeCode") String employeeCode,
            @RequestParam("companyCode") String companyCode,
            @RequestParam("infoMarry") String infoMarry,
            @RequestParam("infoEmail") String infoEmail,
            @RequestParam("infoPhone") String infoPhone,
            @RequestParam("infoStartDate") Date infoStartDate,
            @RequestParam("infoAddressPermanent") String infoAddressPermanent,
            @RequestParam("infoAddressContact") String infoAddressContact,
            @RequestParam("infoReligion") String infoReligion,
            @RequestParam("infoNation") String infoNation,
            @RequestParam("infoNationality") String infoNationality,
            @RequestParam("infoCulturalLevel") String infoCulturalLevel,
            @RequestParam("infoCitizenshipIdentity") String infoCitizenshipIdentity,
            @RequestParam("issueDate") String issueDate,
            @RequestParam("infoPlaceDate") String infoPlaceDate,
            @RequestParam("infoNameBank") String infoNameBank,
            @RequestParam("infoNameEmployeeBank") String infoNameEmployeeBank,
            @RequestParam("infoNumberBank") String infoNumberBank,
            @RequestParam("infoMedicalDanger") String infoMedicalDanger,
            @RequestParam("position") String position,
            @RequestParam("employeeImages") MultipartFile employeeImages  // Nhận nhiều file ảnh
    ) throws ForbiddenException, TooManyRequestsException, InternalServerException, UnauthorizedException, BadRequestException, UnknownException, IOException, ParseException {
        InfoEmployeeCreate infoEmployeeRequest = new InfoEmployeeCreate();
        infoEmployeeRequest.setEmployeeCode(employeeCode);


        infoEmployeeRequest.setMaritalStatus(infoMarry);
        infoEmployeeRequest.setEmail(infoEmail);;
        infoEmployeeRequest.setPhone(infoPhone);
        infoEmployeeRequest.setHireDate(infoStartDate);
        infoEmployeeRequest.setPermanentAddress(infoAddressPermanent);
        infoEmployeeRequest.setContactAddress(infoAddressContact);
        infoEmployeeRequest.setReligion(infoReligion);
        infoEmployeeRequest.setEthnicity(infoNation);
        infoEmployeeRequest.setNationality(infoNationality);
        infoEmployeeRequest.setEducation(infoCulturalLevel);
        infoEmployeeRequest.setIdCard(infoCitizenshipIdentity);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = formatter.parse(issueDate);
        infoEmployeeRequest.setIssueDate(date);
        infoEmployeeRequest.setIssuePlace(infoPlaceDate);
        infoEmployeeRequest.setBankName(infoNameBank);
        infoEmployeeRequest.setAccountName(infoNameEmployeeBank);
        infoEmployeeRequest.setAccountNumber(infoNumberBank);
        infoEmployeeRequest.setPosition(position);
        infoEmployeeRequest.setSocialInsuranceNumber(infoMedicalDanger);


        Result resultEmail = imageKitService.uploadFromBytes(employeeImages);



        return infoEmployeeService.createInfoEmployee(
               infoEmployeeRequest, resultEmail.getUrl()
        );
    }


    @PutMapping("/{employeeCode}")
    public ApiResponse<?> updateInfoEmployee(
            @PathVariable String employeeCode,
            @RequestParam("employeeData") String employeeData,
            @RequestParam(value = "image", required = false) MultipartFile image
    ) throws ForbiddenException, TooManyRequestsException, InternalServerException, UnauthorizedException, BadRequestException, UnknownException, IOException, ParseException {
        // Convert employee data from JSON string to InfoEmployeeCreate DTO
        InfoEmployeeCreate userData = new ObjectMapper().readValue(employeeData, InfoEmployeeCreate.class);


        InfoEmployeeCreate infoEmployeeRequest = new InfoEmployeeCreate();
        infoEmployeeRequest.setEmployeeCode(employeeCode);

        infoEmployeeRequest.setMaritalStatus(userData.getMaritalStatus());
        infoEmployeeRequest.setEmail(userData.getEmail());;
        infoEmployeeRequest.setPhone(userData.getPhone());
        infoEmployeeRequest.setHireDate(userData.getHireDate());
        infoEmployeeRequest.setDob(userData.getDob());
        infoEmployeeRequest.setPermanentAddress(userData.getPermanentAddress());
        infoEmployeeRequest.setContactAddress(userData.getContactAddress());
        infoEmployeeRequest.setReligion(userData.getReligion());
        infoEmployeeRequest.setEthnicity(userData.getEthnicity());
        infoEmployeeRequest.setNationality(userData.getNationality());
        infoEmployeeRequest.setEducation(userData.getEducation());
        infoEmployeeRequest.setIdCard(userData.getIdCard());
        infoEmployeeRequest.setIssueDate(userData.getIssueDate());
        infoEmployeeRequest.setIssuePlace(userData.getIssuePlace());
        infoEmployeeRequest.setBankName(userData.getBankName());
        infoEmployeeRequest.setAccountName(userData.getAccountName());
        infoEmployeeRequest.setAccountNumber(userData.getAccountNumber());
        infoEmployeeRequest.setPosition(userData.getPosition());
        infoEmployeeRequest.setSocialInsuranceNumber(userData.getSocialInsuranceNumber());


        if (image!= null){
            Result resultEmail = imageKitService.uploadFromBytes(image);
            infoEmployeeRequest.setImage(resultEmail.getUrl());
        }




        return infoEmployeeService.updateInfoEmployee(employeeCode, infoEmployeeRequest);
    }
    @DeleteMapping("/{employeeCode}")
    public void deleteInfoEmployee(@PathVariable String employeeCode) {
        infoEmployeeService.deleteInfoEmployee(employeeCode);
    }
}

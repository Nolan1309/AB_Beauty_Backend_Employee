package com.example.employee.service;

import com.example.employee.dto.ApiResponse;
import com.example.employee.dto.info_employee.InfoEmployeeCreate;
import com.example.employee.dto.info_employee.InfoEmployeePublicDTO;
import com.example.employee.dto.info_employee.InfoEmployeeRequest;
import com.example.employee.model.Employee;
import com.example.employee.model.InfoEmployee;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.repository.InfoEmployeeRepository;
import com.example.employee.service.impl.InfoEmployeeService;
import io.imagekit.sdk.models.results.Result;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class InfoEmployeeServiceImpl implements InfoEmployeeService {

    @Autowired
    private InfoEmployeeRepository infoEmployeeRepository;

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    @Lazy
    public List<InfoEmployee> getAllInfoEmployee() {
        return infoEmployeeRepository.findAll();
    }

    @Override
    public ApiResponse<?> getInfoEmployeeByEmployeeCode(String employeeCode) {
        InfoEmployee infoEmployee = infoEmployeeRepository.findInfoEmployeeByEmployeeEmployeeCode(employeeCode);

        if (infoEmployee == null) {
            return new ApiResponse<>("Employee not found", null, 404);
        }

        InfoEmployeeCreate responseDTO = new InfoEmployeeCreate();
        responseDTO.setEmployeeCode(infoEmployee.getEmployee().getEmployeeCode());
        responseDTO.setImage(infoEmployee.getEmployee().getEmployeeImage());
        responseDTO.setEmployeeId(infoEmployee.getEmployee().getId().toString());
        responseDTO.setHireDate(infoEmployee.getInfoStartDate());
        responseDTO.setCompanyCode(infoEmployee.getEmployee().getDepartment().getCompany().getCompanyCode());
        responseDTO.setFullname(infoEmployee.getEmployee().getEmployeeName());
        responseDTO.setDob(infoEmployee.getInfoDob());
        responseDTO.setMaritalStatus(infoEmployee.getInfoMarry());
        responseDTO.setEmail(infoEmployee.getInfoEmail());
        responseDTO.setPhone(infoEmployee.getInfoPhone());
        responseDTO.setPermanentAddress(infoEmployee.getInfoAddressPermanent());
        responseDTO.setContactAddress(infoEmployee.getInfoAddressContact());
        responseDTO.setReligion(infoEmployee.getInfoReligion());
        responseDTO.setEthnicity(infoEmployee.getInfoNation());
        responseDTO.setNationality(infoEmployee.getInfoNationality());
        responseDTO.setEducation(infoEmployee.getInfoCulturalLevel());
        responseDTO.setIdCard(infoEmployee.getInfoCitizenshipIdentity());
        responseDTO.setIssueDate(infoEmployee.getInfoIssueDate());
        responseDTO.setIssuePlace(infoEmployee.getInfoPlaceDate());
        responseDTO.setBankName(infoEmployee.getInfoNameBank());
        responseDTO.setAccountName(infoEmployee.getInfoNameEmployeeBank());
        responseDTO.setAccountNumber(infoEmployee.getInfoNumberBank());
        responseDTO.setSocialInsuranceNumber(infoEmployee.getInfoMedicalDanger());
        responseDTO.setPosition(infoEmployee.getPosition());

        return new ApiResponse<>("Employee info retrieved successfully.", responseDTO, 200);
    }

    @Override
    @Transactional
    public ApiResponse<?> createInfoEmployee(InfoEmployeeCreate infoEmployeeRequest, String employeeImages) {
        try {
            // Tạo đối tượng InfoEmployee từ request
            InfoEmployee infoEmployee = new InfoEmployee();

            // Gán các giá trị từ DTO sang entity
            infoEmployee.setEmployee(employeeRepository.findEmployeeByEmployeeCode(infoEmployeeRequest.getEmployeeCode()));
            infoEmployee.setInfoMarry(infoEmployeeRequest.getMaritalStatus());
            infoEmployee.setInfoEmail(infoEmployeeRequest.getEmail());
            infoEmployee.setInfoPhone(infoEmployeeRequest.getPhone());
            infoEmployee.setInfoStartDate(infoEmployeeRequest.getHireDate());
            infoEmployee.setInfoAddressPermanent(infoEmployeeRequest.getPermanentAddress());
            infoEmployee.setInfoAddressContact(infoEmployeeRequest.getContactAddress());
            infoEmployee.setInfoReligion(infoEmployeeRequest.getReligion());
            infoEmployee.setInfoNation(infoEmployeeRequest.getEthnicity());
            infoEmployee.setInfoNationality(infoEmployeeRequest.getNationality());
            infoEmployee.setInfoCulturalLevel(infoEmployeeRequest.getEducation());
            infoEmployee.setInfoCitizenshipIdentity(infoEmployeeRequest.getIdCard());
            infoEmployee.setInfoIssueDate(infoEmployeeRequest.getIssueDate());
            infoEmployee.setInfoPlaceDate(infoEmployeeRequest.getIssuePlace());
            infoEmployee.setInfoNameBank(infoEmployeeRequest.getBankName());
            infoEmployee.setInfoNameEmployeeBank(infoEmployeeRequest.getAccountName());
            infoEmployee.setInfoNumberBank(infoEmployeeRequest.getAccountNumber());
            infoEmployee.setInfoMedicalDanger(infoEmployeeRequest.getSocialInsuranceNumber());
            infoEmployee.setPosition(infoEmployeeRequest.getPosition());

            if (employeeImages!= null)
            {
                Employee employee = employeeRepository.findEmployeeByEmployeeCode(infoEmployeeRequest.getEmployeeCode());
                if(employee!= null){
                    employee.setEmployeeImage(employeeImages);
                    employeeRepository.saveAndFlush(employee);
                }
            }
            infoEmployeeRepository.save(infoEmployee);

            return new ApiResponse<>("InfoEmployee created successfully.", infoEmployee, 200);
        } catch (Exception e) {
            return new ApiResponse<>("Error occurred while creating InfoEmployee: " + e.getMessage(), null, 500);
        }
    }
    @Override
    @Transactional
    public ApiResponse<?> updateInfoEmployee(String employeeCode, InfoEmployeeCreate infoEmployeeRequest) {
        try {
            InfoEmployee infoEmployee = infoEmployeeRepository.findInfoEmployeeByEmployeeEmployeeCode(employeeCode);
            if (infoEmployee == null) {
                return new ApiResponse<>("InfoEmployee not found with employee code: " + employeeCode, null, 404);
            }
            infoEmployee.setInfoMarry(infoEmployeeRequest.getMaritalStatus());
            infoEmployee.setInfoEmail(infoEmployeeRequest.getEmail());
            infoEmployee.setInfoPhone(infoEmployeeRequest.getPhone());
            infoEmployee.setInfoDob(infoEmployeeRequest.getDob());
            infoEmployee.setInfoStartDate(infoEmployeeRequest.getHireDate());
            infoEmployee.setInfoAddressPermanent(infoEmployeeRequest.getPermanentAddress());
            infoEmployee.setInfoAddressContact(infoEmployeeRequest.getContactAddress());
            infoEmployee.setInfoReligion(infoEmployeeRequest.getReligion());
            infoEmployee.setInfoNation(infoEmployeeRequest.getEthnicity());
            infoEmployee.setInfoNationality(infoEmployeeRequest.getNationality());
            infoEmployee.setInfoCulturalLevel(infoEmployeeRequest.getEducation());
            infoEmployee.setInfoCitizenshipIdentity(infoEmployeeRequest.getIdCard());
            infoEmployee.setInfoIssueDate(infoEmployeeRequest.getIssueDate());
            infoEmployee.setInfoPlaceDate(infoEmployeeRequest.getIssuePlace());
            infoEmployee.setInfoNameBank(infoEmployeeRequest.getBankName());
            infoEmployee.setInfoNameEmployeeBank(infoEmployeeRequest.getAccountName());
            infoEmployee.setInfoNumberBank(infoEmployeeRequest.getAccountNumber());
            infoEmployee.setInfoMedicalDanger(infoEmployeeRequest.getSocialInsuranceNumber());
            infoEmployee.setPosition(infoEmployeeRequest.getPosition());

            if (infoEmployeeRequest.getImage()!= null)
            {
                Employee employee = employeeRepository.findEmployeeByEmployeeCode(infoEmployeeRequest.getEmployeeCode());
                if(employee!= null){
                    employee.setEmployeeImage(infoEmployeeRequest.getImage());
                    employeeRepository.saveAndFlush(employee);
                }
            }

            // Lưu cập nhật vào cơ sở dữ liệu
            infoEmployeeRepository.saveAndFlush(infoEmployee);

            return new ApiResponse<>("InfoEmployee updated successfully.", infoEmployeeRequest, 200);
        } catch (Exception e) {
            return new ApiResponse<>("Error occurred while updating InfoEmployee: " + e.getMessage(), null, 500);
        }
    }

    @Override
    public void deleteInfoEmployee(String employeeCode) {

    }

    @Override
    public InfoEmployeePublicDTO getPublicEmployeeInfo(String employeeCode) {
        return infoEmployeeRepository.findPublicEmployeeInfoByCode(employeeCode);
    }
}

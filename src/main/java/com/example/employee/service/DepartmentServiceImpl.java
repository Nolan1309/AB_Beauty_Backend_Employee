package com.example.employee.service;

import com.example.employee.dto.ApiResponse;
import com.example.employee.dto.department.DepartmentDTO;
import com.example.employee.exception.DataNotFoundException;
import com.example.employee.mapper.DepartmentMapper;
import com.example.employee.mapper.EmployeeMapper;
import com.example.employee.model.Company;
import com.example.employee.model.Department;
import com.example.employee.model.Employee;
import com.example.employee.repository.DepartmentRepository;
import com.example.employee.service.impl.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private DepartmentMapper departmentMapper;
    @Override
    public ApiResponse<Page<?>> getAllDepartment(Pageable pageable){
        Page<Department> departments = departmentRepository.findAll(pageable);
        return new ApiResponse<>("Department retrieved successfully.", departments, 200);
    }

    @Override
    public ApiResponse<?> getDepartmentByDepartmentCode(String departmentCode) {
        Department department = departmentRepository.findDepartmentByDepartmentCode(departmentCode);
        if (department == null) {
            throw new DataNotFoundException("Department not found with code: " + departmentCode);
        }
        return new ApiResponse<>("Department found successfully.", department, 200);
    }

    @Override
    public ApiResponse<?> getDepartmentsByCompanyCode(String companyCode) {
        List<Department> departments = departmentRepository.findDepartmentByCompany_CompanyCode(companyCode);
        return new ApiResponse<>("Departments retrieved successfully.", departments, 200);
    }
    

    @Override
    public ApiResponse<?> createDepartment(DepartmentDTO departmentDTO) {
        try {
            Department existingDepartment = departmentRepository.findDepartmentByDepartmentCode(departmentDTO.getCompanyCode());
            if (existingDepartment != null) {
                return new ApiResponse<>("Company with code already exists.", null, 400);
            }
            existingDepartment = departmentMapper.departmentDTOToDepartment(departmentDTO);
            Department department = departmentRepository.save(existingDepartment);
            return new ApiResponse<>("Company created successfully.", department, 200);
        } catch (Exception e) {
            return new ApiResponse<>("Error occurred while creating company: " + e.getMessage(), null, 500);
        }

    }

    @Override
    public ApiResponse<?> updateDepartment(String departmentCode, DepartmentDTO department){
        Department existDepartment = departmentRepository.findDepartmentByDepartmentCode(departmentCode);
        if (existDepartment == null){
            return new ApiResponse<>("Department No Found", null,404);
        }
        existDepartment = DepartmentMapper.INSTANCE.departmentDTOToDepartment(department);
        Department departmentUpdate =departmentRepository.saveAndFlush(existDepartment);
        return new ApiResponse<>("Update successful",departmentUpdate,200);
    }

    @Override
    public ApiResponse<?> deletedDepartment(String departmentCode) {
        Department department = departmentRepository.findDepartmentByDepartmentCode(departmentCode);
        if (department== null){
            return new ApiResponse<>("Department No Found",null,404);
        }
        try {
            departmentRepository.delete(department);
            return new ApiResponse<>("Success",null,200);
        }catch (Exception e){
            return new ApiResponse<>("Loi he thong",null,500);
        }
    }
}

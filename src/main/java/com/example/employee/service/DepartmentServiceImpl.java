package com.example.employee.service;

import com.example.employee.model.Department;
import com.example.employee.repository.DepartmentRepository;
import com.example.employee.service.impl.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(String departmentCode) {
        return departmentRepository.findDepartmentByDepartmentCode(departmentCode);
    }

    @Override
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department updateDepartment(String departmentCode,Department department) {
        return departmentRepository.saveAndFlush(department);
    }

    @Override
    public void deleteDepartment(String departmentCode) {
        Department department = departmentRepository.findDepartmentByDepartmentCode(departmentCode);
        if (department != null){
            departmentRepository.delete(department);
        }
    }
}

package com.example.employee.service;

import com.example.employee.dto.ApiResponse;
import com.example.employee.dto.employee.EmployeeDTO;
import com.example.employee.mapper.CompanyMapper;
import com.example.employee.mapper.EmployeeMapper;
import com.example.employee.model.Company;
import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.service.impl.EmployeeService;
import com.example.employee.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;


@Service
public class EmployeeServiceImpl implements  UserService, EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public ApiResponse<Page<?>> getAllEmployee(Pageable pageable) {
        Page<Employee> employees = employeeRepository.findAll(pageable);
        return ApiResponse.success("Employees retrieved successfully.", employees);
    }

    @Override
    public Page<Employee> getEmployeesInSameCompany(String employeeCode, Pageable pageable) {
        Employee employee = employeeRepository.findEmployeeByEmployeeCode(employeeCode);
        String companyCode = employee.getDepartment().getCompany().getCompanyCode();
        return employeeRepository.findByCompanyCode(companyCode, pageable);
    }

    @Override
    public ApiResponse<?> getEmployeeByEmployeeCode(String employeeCode) {
        Employee employee = employeeRepository.findEmployeeByEmployeeCode(employeeCode);
        if (employee == null) {
            return ApiResponse.notFound("Employee not found.");
        }
        return ApiResponse.success("Employee retrieved successfully.", employee);
    }

    @Override
    public ApiResponse<?> createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeRepository.findEmployeeByEmployeeCode(employeeDTO.getEmployeeCode());
        if (employee != null) {
            return ApiResponse.error("Employee Already Exist", 400);
        }
        try {
            Employee employeeCreate = employeeMapper.employeeDTOToEmployee(employeeDTO);
            employeeRepository.save(employeeCreate);
            return ApiResponse.success("Employee created successfully", employeeCreate);
        } catch (Exception e) {
            return ApiResponse.error("System Error: " + e.getMessage(), 500);
        }
    }

    @Override
    public ApiResponse<?> updateEmployee(String employeeCode, EmployeeDTO employee) {
        Employee existEmployee = employeeRepository.findEmployeeByEmployeeCode(employeeCode);
        if (existEmployee == null){
            return ApiResponse.notFound("Employee Not Found");
        }
        existEmployee = EmployeeMapper.INSTANCE.employeeDTOToEmployee(employee);
        Employee update = employeeRepository.saveAndFlush(existEmployee);
        return ApiResponse.success("Update successful", update);
    }


    @Override
    public ApiResponse<?> deletedEmployee(String employeeCode) {
        Employee employee = employeeRepository.findEmployeeByEmployeeCode(employeeCode);
        if (employee == null){
            return ApiResponse.notFound("Employee Not Found");
        }
        try {
            employeeRepository.delete(employee);
            return ApiResponse.success("Employee deleted successfully", null);
        } catch (Exception e){
            return ApiResponse.error("System error: " + e.getMessage(), 500);
        }
    }

    @Override
    public Employee findByEmail(String email) {
        return employeeRepository.findEmployeeByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
    }
    @Override
    public Employee getEmployeeByEmail(String email) {
        return employeeRepository.findEmployeeByEmail(email).get();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findEmployeeByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + username));
        return new User(employee.getEmployeeEmail(), employee.getPassword(), getAuthorities(employee));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(Employee employee) {
        if (employee != null) {
            return Arrays.asList(new SimpleGrantedAuthority(employee.getRole().getName()));
        }
        return Arrays.asList();
    }
}

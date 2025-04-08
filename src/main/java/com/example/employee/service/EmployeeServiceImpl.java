package com.example.employee.service;

import com.example.employee.dto.CouponResponseDTO;
import com.example.employee.model.Coupon;
import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.service.impl.EmployeeService;
import com.example.employee.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements  UserService, EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Page<Employee> getEmployeesInSameCompany(String employeeCode, Pageable pageable) {
        Employee employee = employeeRepository.findEmployeeByEmployeeCode(employeeCode);

        String companyCode = employee.getDepartment().getCompany().getCompanyCode();
        return employeeRepository.findByCompanyCode(companyCode, pageable);
    }

    @Override
    public Employee getEmployeeById(String employeeCode) {
        return employeeRepository.findEmployeeByEmployeeCode(employeeCode);
    }

    @Override
    public Employee getEmployeeByEmail(String email) {
        return employeeRepository.findEmployeeByEmail(email).get();
    }

    @Override
    public Employee createEmployee(Employee employeeCode) {
        return employeeRepository.save(employeeCode);
    }

    @Override
    public Employee updateEmployee(String employeeCode,Employee employee) {
        Employee employeeFind = employeeRepository.findEmployeeByEmployeeCode(employeeCode);
        employeeFind = employee;
        return employeeRepository.saveAndFlush(employeeFind);
    }

    @Override
    public void deleteEmployee(String employeeCode) {
        Employee employee = employeeRepository.findEmployeeByEmployeeCode(employeeCode);
        if (employee!= null){
            employeeRepository.delete(employee);
        }
    }

    @Override
    public Employee findByEmail(String email) {
        return employeeRepository.findEmployeeByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
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

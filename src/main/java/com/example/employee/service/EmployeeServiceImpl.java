package com.example.employee.service;

import com.example.employee.dto.ApiResponse;
import com.example.employee.dto.auth.ChangePasswordDTO;
import com.example.employee.dto.employee.EmployeeColleaguesDTO;
import com.example.employee.dto.employee.EmployeeDTO;
import com.example.employee.dto.employee.EmployeeProfileDTO;
import com.example.employee.mapper.CompanyMapper;
import com.example.employee.mapper.EmployeeMapper;
import com.example.employee.model.Company;
import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.service.impl.EmployeeService;
import com.example.employee.service.impl.UserService;
import com.example.employee.util.PasswordEncoderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
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
import java.util.stream.Collectors;


@Service
public class EmployeeServiceImpl implements  UserService, EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private PasswordEncoderUtil passwordEncoderUtil;


    @Override
    public ApiResponse<Page<?>> getAllEmployee(Pageable pageable) {
        Page<Employee> employees = employeeRepository.findAll(pageable);
        return ApiResponse.success("Employees retrieved successfully.", employees);
    }

    @Override
    public Page<EmployeeColleaguesDTO> getEmployeesInSameCompany(String employeeCode, Pageable pageable) {
        // Tìm thông tin nhân viên theo employeeCode
        Employee employee = employeeRepository.findEmployeeByEmployeeCode(employeeCode);
        if (employee == null) {
            throw new RuntimeException("Employee not found.");
        }

        // Lấy mã công ty của nhân viên
        String companyCode = employee.getDepartment().getCompany().getCompanyCode();

        // Lấy danh sách các nhân viên cùng công ty
        Page<Employee> colleagues = employeeRepository.findByCompanyCode(companyCode, pageable);

        // Chuyển đổi danh sách Employee thành danh sách EmployeeColleaguesDTO
        List<EmployeeColleaguesDTO> colleaguesDTOList = colleagues.getContent().stream()
                .map(emp -> new EmployeeColleaguesDTO(
                        emp.getId(),
                        emp.getEmployeeCode(),
                        emp.getEmployeeName(),
                        emp.getEmail(),
                        emp.getEmployeePhoneNumber(),
                        emp.getEmployeeLastLogin(),
                        emp.getEmployeeActive(),
                        emp.getDepartment().getCompany().getCompanyCode(),
                        emp.getDepartment().getCompany().getCompanyName()
                ))
                .collect(Collectors.toList());

        // Trả về Page chứa các DTO
        return new PageImpl<>(colleaguesDTOList, pageable, colleagues.getTotalElements());
    }

    @Override
    public EmployeeProfileDTO getEmployeeProfile(String employeeCode) {
        // Tìm thông tin nhân viên theo employeeCode
        Employee employee = employeeRepository.findEmployeeByEmployeeCode(employeeCode);

        if (employee == null) {
            throw new RuntimeException("Employee not found.");
        }

        // Chuyển đổi từ Employee sang EmployeeProfileDTO
        EmployeeProfileDTO profileDTO = new EmployeeProfileDTO();
        profileDTO.setEmployeeId(employee.getId());
        profileDTO.setEmployeeCode(employee.getEmployeeCode());
        profileDTO.setEmployeeName(employee.getEmployeeName());
        profileDTO.setEmail(employee.getEmail());
        profileDTO.setEmployeePhoneNumber(employee.getEmployeePhoneNumber());
        profileDTO.setEmployeeLastLogin(employee.getEmployeeLastLogin().toString()); // chuyển đổi thành chuỗi nếu cần
        profileDTO.setEmployeeActive(employee.getEmployeeActive());
        profileDTO.setCompanyCode(employee.getDepartment().getCompany().getCompanyCode());
        profileDTO.setCompanyName(employee.getDepartment().getCompany().getCompanyName());

        return profileDTO;
    }
    @Override
    public ApiResponse<?> getEmployeeByEmployeeCode(String employeeCode) {
        // Tìm nhân viên theo employeeCode
        Employee employee = employeeRepository.findEmployeeByEmployeeCode(employeeCode);

        if (employee == null) {
            return ApiResponse.notFound("Employee not found.");
        }

        // Chuyển đổi Employee thành EmployeeDTO
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setEmployeeCode(employee.getEmployeeCode());
        employeeDTO.setEmployeeName(employee.getEmployeeName());
        employeeDTO.setEmail(employee.getEmail());
        employeeDTO.setImage(employee.getEmployeeImage());
        employeeDTO.setEmployeePhoneNumber(employee.getEmployeePhoneNumber());
        employeeDTO.setEmployeeLastLogin(employee.getEmployeeLastLogin());
        employeeDTO.setEmployeeActive(employee.getEmployeeActive());
        employeeDTO.setCompanyCode(employee.getDepartment().getCompany().getCompanyCode());
        employeeDTO.setCompanyName(employee.getDepartment().getCompany().getCompanyName());

        // Set các thông tin tài chính của nhân viên
        employeeDTO.setEmployeeTotalLTL(employee.getEmployeeTotalLTL());
        employeeDTO.setEmployeeTotalLKF(employee.getEmployeeTotalLKF());
        employeeDTO.setEmployeeTotalLKF_M(employee.getEmployeeTotalLKF_M());
        employeeDTO.setEmployeeTotalLDL(employee.getEmployeeTotalLDL());
        employeeDTO.setEmployeeTotalABD(employee.getEmployeeTotalABD());
        employeeDTO.setEmployeeTotalABT(employee.getEmployeeTotalABT());
        employeeDTO.setEmployeeTotalABBW(employee.getEmployeeTotalABBW());
        employeeDTO.setEmployeeTotalABBW_ABB(employee.getEmployeeTotalABBW_ABB());
        employeeDTO.setEmployeeTotalAffiliate(employee.getEmployeeTotalAffiliate());
        employeeDTO.setEmployeeBalance(employee.getEmployeeBalance());
        employeeDTO.setEmployeeTotalWithdraw(employee.getEmployeeTotalWithdraw());

        // Set department code và role id
        employeeDTO.setDepartmentCode(employee.getDepartment().getDepartmentCode());
        employeeDTO.setRoleId(employee.getRole() != null ? employee.getRole().getId() : null);

        // Trả về EmployeeDTO trong ApiResponse
        return ApiResponse.success("Employee retrieved successfully.", employeeDTO);
    }

    @Override
    public ApiResponse<?> changePassword(String employeeCode, ChangePasswordDTO changePasswordDTO) {

        Employee employee = employeeRepository.findEmployeeByEmployeeCode(employeeCode);
        if (employee == null) {
            return ApiResponse.error("Employee not found.", 404);
        }

        if (!passwordEncoderUtil.matches(changePasswordDTO.getOldPassword(), employee.getPassword())) {
            return ApiResponse.error("Old password is incorrect.", 400);
        }

        if (!changePasswordDTO.getNewPassword().equals(changePasswordDTO.getConfirmPassword())) {
            return ApiResponse.error("New password and confirmation password do not match.", 400);
        }

        employee.setPassword(passwordEncoderUtil.encode(changePasswordDTO.getNewPassword()));
        employeeRepository.save(employee);

        return ApiResponse.success("Password updated successfully.", null);
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

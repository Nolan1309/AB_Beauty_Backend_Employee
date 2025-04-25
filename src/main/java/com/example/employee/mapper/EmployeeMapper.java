package com.example.employee.mapper;

import com.example.employee.dto.employee.EmployeeDTO;
import com.example.employee.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    @Mapping(source = "department.departmentCode", target = "departmentCode")
    @Mapping(source = "role.id", target = "roleId")
    @Mapping(source = "department.company.companyCode", target = "companyCode")
    @Mapping(source = "department.company.companyName", target = "companyName")
    EmployeeDTO employeeToEmployeeDTO(Employee employee);

    @Mapping(target = "department", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "authorities", ignore = true)
    @Mapping(target = "employeeEmail", source = "email")
    Employee employeeDTOToEmployee(EmployeeDTO employeeDTO);
}

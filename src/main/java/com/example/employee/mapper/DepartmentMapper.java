package com.example.employee.mapper;

import com.example.employee.dto.department.DepartmentDTO;
import com.example.employee.model.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);

    DepartmentDTO departmentToDepartmentDTO(Department department);

    Department departmentDTOToDepartment(DepartmentDTO departmentDTO);
}

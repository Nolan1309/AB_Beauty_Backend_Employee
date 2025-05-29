package com.example.employee.mapper;

import com.example.employee.dto.company.CompanyDTO;
import com.example.employee.model.Company;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")  // `spring` để MapStruct tích hợp với Spring Dependency Injection
public interface CompanyMapper {

    CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);  // MapStruct sẽ tự động tạo ra instance

    // Chuyển từ DTO sang Entity
    Company toEntity(CompanyDTO companyDTO);

    // Chuyển từ Entity sang DTO
    CompanyDTO toDto(Company company);
}
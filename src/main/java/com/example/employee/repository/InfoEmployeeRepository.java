package com.example.employee.repository;

import com.example.employee.dto.InfoEmployeePublicDTO;
import com.example.employee.model.Company;
import com.example.employee.model.InfoEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(exported = false)
public interface InfoEmployeeRepository extends JpaRepository<InfoEmployee, Integer> {
    // Phương thức tìm theo employee và id
    InfoEmployee findInfoEmployeeByEmployeeEmployeeCodeAndId(String employeeCode, Integer id);
    InfoEmployee findInfoEmployeeByEmployeeEmployeeCode(String employeeCode);

    @Query("SELECT new com.example.employee.dto.InfoEmployeePublicDTO(" +
            "e.employeeCode, e.employeeName, e.employeePhoneNumber, " +
            "ie.infoNameBank, ie.infoNameEmployeeBank, ie.infoCulturalLevel, " +
            "ie.infoStartDate, ie.infoAddressPermanent, ie.infoAddressContact, " +
            "d.departmentCode, d.departmentName) " +
            "FROM InfoEmployee ie " +
            "JOIN ie.employee e " +
            "JOIN e.department d " +
            "WHERE e.employeeCode = :employeeCode")
    InfoEmployeePublicDTO findPublicEmployeeInfoByCode(@Param("employeeCode") String employeeCode);
}

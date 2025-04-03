package com.example.employee.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Entity
@Data
@Table(name = "info_employee")
public class InfoEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "employee_code", referencedColumnName = "employee_code")
    private Employee employee;

    @Temporal(TemporalType.DATE)
    @Column(name = "info_start_Date")
    private Date infoStartDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "info_seniority_Date")
    private Date infoSeniorityDate;

    @Column(name = "info_marry",length = 10)
    private String infoMarry;

    @Column(name = "info_email",length = 100)
    private String infoEmail;

    @Column(name = "info_phone", length= 15)
    private String infoPhone;

    @Lob
    @Column(name = "info_address_Permanent",columnDefinition = "TEXT")
    private String infoAddressPermanent;

    @Lob
    @Column(name = "info_address_Contact",columnDefinition = "TEXT")
    private String infoAddressContact;

    @Column(name = "info_religion",length = 50)
    private String infoReligion;

    @Column(name = "info_nation",length = 50)
    private String infoNation;

    @Column(name = "info_nationality",length = 50)
    private String infoNationality;

    @Column(name = "info_cultural_level",length = 50)
    private String infoCulturalLevel;

    @Column(name = "info_citizenship_identity", length= 20)
    private String infoCitizenshipIdentity;

    @Temporal(TemporalType.DATE)
    @Column(name = "info_issue_date")
    private Date infoIssueDate;

    @Column(name = "info_place_date",length = 255)
    private String infoPlaceDate;

    @Column(name = "info_name_bank",length = 100)
    private String infoNameBank;

    @Column(name = "info_name_employeeBank",length = 100)
    private String infoNameEmployeeBank;

    @Column(name = "info_number_bank",length = 20)
    private String infoNumberBank;

    @Column(name = "info_medical_danger",length = 255)
    private String infoMedicalDanger;
}

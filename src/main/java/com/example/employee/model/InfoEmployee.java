package com.example.employee.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Entity
@Data
// @JsonInclude(JsonInclude.Include.NON_NULL)
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

    @Column(name = "info_marry")
    private String infoMarry;

    @Column(name = "info_email")
    private String infoEmail;

    @Column(name = "info_phone")
    private String infoPhone;

    @Lob
    @Column(name = "info_address_Permanent",columnDefinition = "TEXT")
    private String infoAddressPermanent;

    @Lob
    @Column(name = "info_address_Contact",columnDefinition = "TEXT")
    private String infoAddressContact;

    @Column(name = "info_religion")
    private String infoReligion;

    @Column(name = "info_nation")
    private String infoNation;

    @Column(name = "info_nationality")
    private String infoNationality;

    @Column(name = "info_cultural_level")
    private String infoCulturalLevel;

    @Column(name = "info_citizenship_identity")
    private String infoCitizenshipIdentity;

    @Temporal(TemporalType.DATE)
    @Column(name = "info_issue_date")
    private Date infoIssueDate;

    @Column(name = "info_place_date")
    private String infoPlaceDate;

    @Column(name = "info_name_bank")
    private String infoNameBank;

    @Column(name = "info_name_employeeBank")
    private String infoNameEmployeeBank;

    @Column(name = "info_number_bank")
    private String infoNumberBank;

    @Column(name = "info_dob")
    private Date infoDob;

    @Column(name = "info_medical_danger")
    private String infoMedicalDanger;

    @Column(name = "position")
    private String position;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getInfoStartDate() {
        return infoStartDate;
    }

    public void setInfoStartDate(Date infoStartDate) {
        this.infoStartDate = infoStartDate;
    }

    public Date getInfoSeniorityDate() {
        return infoSeniorityDate;
    }

    public void setInfoSeniorityDate(Date infoSeniorityDate) {
        this.infoSeniorityDate = infoSeniorityDate;
    }

    public String getInfoMarry() {
        return infoMarry;
    }

    public void setInfoMarry(String infoMarry) {
        this.infoMarry = infoMarry;
    }

    public String getInfoEmail() {
        return infoEmail;
    }

    public void setInfoEmail(String infoEmail) {
        this.infoEmail = infoEmail;
    }

    public String getInfoPhone() {
        return infoPhone;
    }

    public void setInfoPhone(String infoPhone) {
        this.infoPhone = infoPhone;
    }

    public String getInfoAddressPermanent() {
        return infoAddressPermanent;
    }

    public void setInfoAddressPermanent(String infoAddressPermanent) {
        this.infoAddressPermanent = infoAddressPermanent;
    }

    public String getInfoAddressContact() {
        return infoAddressContact;
    }

    public void setInfoAddressContact(String infoAddressContact) {
        this.infoAddressContact = infoAddressContact;
    }

    public String getInfoReligion() {
        return infoReligion;
    }

    public void setInfoReligion(String infoReligion) {
        this.infoReligion = infoReligion;
    }

    public String getInfoNation() {
        return infoNation;
    }

    public void setInfoNation(String infoNation) {
        this.infoNation = infoNation;
    }

    public String getInfoNationality() {
        return infoNationality;
    }

    public void setInfoNationality(String infoNationality) {
        this.infoNationality = infoNationality;
    }

    public String getInfoCulturalLevel() {
        return infoCulturalLevel;
    }

    public void setInfoCulturalLevel(String infoCulturalLevel) {
        this.infoCulturalLevel = infoCulturalLevel;
    }

    public String getInfoCitizenshipIdentity() {
        return infoCitizenshipIdentity;
    }

    public void setInfoCitizenshipIdentity(String infoCitizenshipIdentity) {
        this.infoCitizenshipIdentity = infoCitizenshipIdentity;
    }

    public Date getInfoIssueDate() {
        return infoIssueDate;
    }

    public void setInfoIssueDate(Date infoIssueDate) {
        this.infoIssueDate = infoIssueDate;
    }

    public String getInfoPlaceDate() {
        return infoPlaceDate;
    }

    public void setInfoPlaceDate(String infoPlaceDate) {
        this.infoPlaceDate = infoPlaceDate;
    }

    public String getInfoNameBank() {
        return infoNameBank;
    }

    public void setInfoNameBank(String infoNameBank) {
        this.infoNameBank = infoNameBank;
    }

    public String getInfoNameEmployeeBank() {
        return infoNameEmployeeBank;
    }

    public void setInfoNameEmployeeBank(String infoNameEmployeeBank) {
        this.infoNameEmployeeBank = infoNameEmployeeBank;
    }

    public String getInfoNumberBank() {
        return infoNumberBank;
    }

    public void setInfoNumberBank(String infoNumberBank) {
        this.infoNumberBank = infoNumberBank;
    }

    public String getInfoMedicalDanger() {
        return infoMedicalDanger;
    }

    public void setInfoMedicalDanger(String infoMedicalDanger) {
        this.infoMedicalDanger = infoMedicalDanger;
    }
}

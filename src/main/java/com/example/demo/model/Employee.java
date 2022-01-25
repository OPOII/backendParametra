package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@Table(name = "EMPLOYEE")
public class Employee {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "EMPLOYEE_ID_GENERATOR", sequenceName = "EMPLOYEE_SEQ")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "EMPLOYEE_ID_GENERATOR")
    @Column
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)

    private Long id;
    @NotNull
    private String name;

    @NotNull
    private String lastName;

    @NotNull
    private String documentType;

    @NotNull
    private String documentNumber;

    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date birthDate;

    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date companyBondingDate;

    @NotNull
    private String position;

    @NotNull
    private double salary;

    public Employee(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getCompanyBondingDate() {
        return companyBondingDate;
    }

    public void setCompanyBondingDate(Date companyBondingDate) {
        this.companyBondingDate = companyBondingDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

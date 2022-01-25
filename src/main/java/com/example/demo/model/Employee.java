package com.example.demo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

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
    private Date birthDate;

    @NotNull
    private Date companyBondingDate;

    @NotNull
    private String position;

    @NotNull
    private double salary;

    public Employee(){

    }

}

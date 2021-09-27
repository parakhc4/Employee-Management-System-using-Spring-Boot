package com.mycompany.springbootproject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "compTable")
public class Compliance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int complianceid;

    @Size(min = 2, max = 20)
    @NotNull(message = "Enter Regulation/Legislation Type")
    private String rlType;

    @Size(min = 2, max = 20)
    @NotNull(message = "Enter Details")
    private String details;

    @NotNull(message = "Enter Date of creation")
    private LocalDate createDate;

    @ManyToOne(targetEntity = Department.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "deptTable", referencedColumnName = "departId")
    private Department department;

    @NotNull(message = "Enter employee count")
    private int empCount;

    @NotNull(message = "Enter Status Count")
    private int stsCount;

    @NotNull(message = "Enter Status")
    private String status;


}



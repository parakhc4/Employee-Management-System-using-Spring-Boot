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
@Table(name = "statTable")
public class StatusReport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int statusId;

    @Size(min = 2, max = 20)
    @NotNull(message = "Enter comments")
    private String comments;

    @Size(min = 2, max = 20)
    @NotNull(message = "Enter Details")
    private String details;

    @NotNull(message = "Enter Date of creation")
    private LocalDate createDate;

    @OneToOne(targetEntity = Compliance.class,cascade = CascadeType.ALL)
    @JoinColumn(name="compliance",referencedColumnName = "complianceid")
    @NotNull(message = "Enter Compliance-id")
    private int complianceId;

    @ManyToOne(targetEntity = Department.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "deptTable", referencedColumnName = "departId")
    private Department department;


}



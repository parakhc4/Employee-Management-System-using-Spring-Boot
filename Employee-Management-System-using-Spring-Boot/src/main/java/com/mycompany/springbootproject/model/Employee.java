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
@Table(name = "empTable") // specifies the name of the database table to be used for mapping.
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Size(min = 2, max = 20)
    @NotNull(message = "Pls Enter First Name!")
    private String firstName;
    @Size(min = 2, max = 20)
    @NotNull(message = "Pls Enter Last Name!")
    private String lastName;

    @NotNull(message = "Pls Enter Email")
    @Email
    private String email;
    @NotNull
    private LocalDate dob;
    //Employee Email


    @ManyToOne(targetEntity = Department.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "deptTable", referencedColumnName = "departId")
    private Department department;

}

package com.mycompany.springbootproject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;

@Data // generates all the boilerplate that is normally associated with simple POJOs
@NoArgsConstructor // will generate a constructor with no parameters
@Entity // annotation specifies that the class is an entity and is mapped to a database table
@Table(name = "empTable") // specifies the name of the database table to be used for mapping.
public class Employee {
    @Id // annotation specifies the primary key of an entity
    @GeneratedValue(strategy = GenerationType.AUTO) // annotation provides for the specification of generation strategies for the values of primary keys
    private Integer id;
    @Size(min = 2, max = 20) // specifies size of the variable
    @NotNull(message = "Pls Enter First Name!") // does not permit to pass a null value
    private String firstName;
    @Size(min = 2, max = 20) // specifies the size of the variable
    @NotNull(message = "Pls Enter Last Name!") // does not permit to pass a null value
    private String lastName;

    @NotNull(message = "Pls Enter Email") // does not permit to pass a null value
    @Email // annotations to validate email address sent to a RESTful Web Service in HTTP GET Request
    private String email;
    @NotNull // does not permit to pass a null value
    private LocalDate dob;
    //Employee Email


    @ManyToOne(targetEntity = Department.class, cascade = CascadeType.ALL) // annotations define many to one relation
    @JoinColumn(name = "deptTable", referencedColumnName = "departId") // marks a column for as a join column for an entity association or an element collection.
    private Department department;

}

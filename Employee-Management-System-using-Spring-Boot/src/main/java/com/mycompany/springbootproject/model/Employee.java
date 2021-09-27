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
@Table(name = "empTable")
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
    //bi directional relationship
    @JoinColumn(name = "deptTable", referencedColumnName = "departId")
    private Department department;

}





/*
package com.mycompany.springbootproject.model;

import lombok.*;
//@Data, @NoArgsConstructor
import javax.persistence.*;
//@Entity, @Id, @GeneratedValue, @Column
import javax.validation.constraints.*;
//@NotNull, @Size

@Data
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "userId", nullable = false)
//    @OneToOne(targetEntity = Employee.class, cascade = CascadeType.ALL)
//    //bi directional relationshiop
//    @JoinColumn(name = "empTable", referencedColumnName = "userId")
    private Integer id;
//
//    @Size(min = 8, max = 20)
//    @NotNull(message = "Kindly Enter Password.")
//    private String password;
//
//    @Size(min = 2, max = 20)
//    @NotNull(message = "Kindly Enter Role.")
//    private String role;
//
//    @NotNull(message = "Kindly Enter Result.")
//    private Integer result;
}

 */

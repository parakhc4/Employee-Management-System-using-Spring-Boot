package com.mycompany.springbootproject.model;

import lombok.Data;

import javax.persistence.*;

//one to many
// mappedBy




@Data
@Entity
@Table(name = "deptTable")
public class Department{
    @Id
    @Column(name = "departId", nullable = false)
    private int departId;
    private String departName;

}
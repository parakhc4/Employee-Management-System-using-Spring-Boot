package com.mycompany.springbootproject.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "deptTable")
public class Department{
    @Id
    @Column(name = "departId", nullable = false)
    private int departId;
    private String departName;

}
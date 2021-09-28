package com.mycompany.springbootproject.exceptions;

public class EmployeeNotFoundException extends  Exception{
    public EmployeeNotFoundException(String message){
        super(message);
    }
}

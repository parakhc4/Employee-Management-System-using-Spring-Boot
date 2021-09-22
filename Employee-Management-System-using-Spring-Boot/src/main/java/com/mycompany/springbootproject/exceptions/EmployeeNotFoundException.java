package com.mycompany.springbootproject.exceptions;

public class EmployeeNotFoundException extends  Exception{
    EmployeeNotFoundException(String message){
        super(message);
    }
}

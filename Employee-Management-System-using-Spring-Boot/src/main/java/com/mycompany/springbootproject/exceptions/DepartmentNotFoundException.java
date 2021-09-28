package com.mycompany.springbootproject.exceptions;

public class DepartmentNotFoundException extends  Exception{
    DepartmentNotFoundException(String message){
        super(message);
    }
}

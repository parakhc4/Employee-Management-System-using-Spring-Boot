package com.mycompany.springbootproject.exceptions;

public class DepartmentNotFoundException extends  Exception{
   public DepartmentNotFoundException(String message){
        super(message);
    }
}

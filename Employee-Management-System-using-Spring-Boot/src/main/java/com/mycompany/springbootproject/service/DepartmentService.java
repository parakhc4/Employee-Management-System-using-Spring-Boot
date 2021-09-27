package com.mycompany.springbootproject.service;


import com.mycompany.springbootproject.model.Department;
import com.mycompany.springbootproject.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {
    public Department addDepartment(Department department);

    public List<Department> getAllDepartments();

    public int getAllDepartCount();

    public void deleteDepartment(int id);

}

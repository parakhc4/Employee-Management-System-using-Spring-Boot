package com.mycompany.springbootproject.service;

import com.mycompany.springbootproject.model.Department;
import com.mycompany.springbootproject.repository.DepartmentRepository;
import com.mycompany.springbootproject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;


    @Override
    public Department addDepartment(Department department) {
        departmentRepository.save(department);
        return department;
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public int getAllDepartCount() {
        return (int)departmentRepository.count();
    }

    @Override
    public void deleteDepartment(int id) {
        departmentRepository.deleteById(id);
    }
}

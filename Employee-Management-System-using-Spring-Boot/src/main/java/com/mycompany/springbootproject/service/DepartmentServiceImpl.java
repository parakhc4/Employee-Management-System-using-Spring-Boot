package com.mycompany.springbootproject.service;

import com.mycompany.springbootproject.model.Department;
import com.mycompany.springbootproject.model.Employee;
import com.mycompany.springbootproject.repository.DepartmentRepository;
import com.mycompany.springbootproject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Department fetchById(int id) {
        Department department = null;
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        if (optionalDepartment.isPresent())
            department = optionalDepartment.get();

        return department;
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

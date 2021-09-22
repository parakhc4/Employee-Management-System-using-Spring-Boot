package com.mycompany.springbootproject.service;

import com.mycompany.springbootproject.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    public List<Employee> getAll();

    public Employee addEmployee(Employee employee);

    Employee fetchById(int id);

    void udpateEmployee(int id, Employee employee);

    void deleteEmployee(int id);
}

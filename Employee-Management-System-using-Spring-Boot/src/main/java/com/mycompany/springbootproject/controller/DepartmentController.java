package com.mycompany.springbootproject.controller;

import com.mycompany.springbootproject.model.Department;
import com.mycompany.springbootproject.model.Employee;
import com.mycompany.springbootproject.service.DepartmentService;
import com.mycompany.springbootproject.service.EmployeeService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//RESTful APIs
@Slf4j
@Controller
@ResponseBody
@RequestMapping("department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/getall")
    @ApiOperation("Fetch All Department Records")
    public List<Department> getDepartments() {
        log.info("INSIDE getDepartments");
        return departmentService.getAllDepartments();
    }

    @GetMapping("/getcount")
    @ApiOperation("Fetch All Department Records")
    public int getDepartmentsCount() {
        log.info("INSIDE getDepartmentsCount");
        return departmentService.getAllDepartCount();
    }

    @ApiOperation("Save a New Department Record.")
    @PostMapping("/create")
    public ResponseEntity<Department> createDepartment(@Valid @RequestBody Department department) {
        log.info("Inside Employee %s", department);
        Department dept = departmentService.addDepartment(department);
        return new ResponseEntity<>(dept, HttpStatus.CREATED);
    }

// annotations, working (mapping, layers, MVC, JPA)
    @ApiOperation("Delete A department")
    @DeleteMapping("/delete/{departId}")
    public ResponseEntity<Void> delete(@PathVariable int departId){
        log.info("Deleting a department with id %d", departId);
        departmentService.deleteDepartment(departId);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

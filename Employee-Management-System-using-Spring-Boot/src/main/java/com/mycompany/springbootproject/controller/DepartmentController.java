package com.mycompany.springbootproject.controller;

import com.mycompany.springbootproject.model.Department;
import com.mycompany.springbootproject.service.DepartmentService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//RESTful APIs
@Slf4j // It offers a generic API making the logging independent of the actual implementation.
@Controller // allows us to auto-detect implementation classes through the classpath scanning.
@ResponseBody // tells a controller that the object returned is automatically serialized into JSON and passed back into the HttpResponse object.
@RequestMapping("department") // the annotation is used to map web requests to Spring Controller methods.
public class DepartmentController {

    @Autowired // Enabling annotation injection, we can use autowiring on properties, setters, and constructors.
    private DepartmentService departmentService;

    //Here, we are fetching all Departments
    @GetMapping("/getall") // annotation that acts as a shortcut for @RequestMapping.
    @ApiOperation("Fetch All Department Records") // annotation to describe the endpoint and its response type
    public List<Department> getDepartments() {
        log.info("INSIDE getDepartments");
        return departmentService.getAllDepartments();
    }

    @ApiOperation("Get A Department By ID") // annotation to describe the endpoint and its response type
    @GetMapping("/getbyid/{id}")  // annotation that acts as a shortcut for @RequestMapping.
    public Department fetchById(@PathVariable int id) {
        return departmentService.fetchById(id);
    }

    @GetMapping("/getcount") // annotation that acts as a shortcut for @RequestMapping.
    @ApiOperation("Fetch All Department Records") // annotation to describe the endpoint and its response type
    public int getDepartmentsCount() {
        log.info("INSIDE getDepartmentsCount");
        return departmentService.getAllDepartCount();
    }

    @ApiOperation("Save a New Department Record.") // annotation to describe the endpoint and its response type
    @PostMapping("/create") // Annotation for mapping HTTP POST requests onto specific handler methods.
    public ResponseEntity<Department> createDepartment(@Valid @RequestBody Department department) {
        log.info("Inside Employee %s", department);
        Department dept = departmentService.addDepartment(department);
        return new ResponseEntity<>(dept, HttpStatus.CREATED);
    }

    // annotations, working (mapping, layers, MVC, JPA)
    @ApiOperation("Delete A department") // annotation to describe the endpoint and its response type
    @DeleteMapping("/delete/{departId}") // annotation maps HTTP DELETE requests onto specific handler methods
    public ResponseEntity<Void> delete(@PathVariable int departId){
        log.info("Deleting a department with id %d", departId);
        departmentService.deleteDepartment(departId);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

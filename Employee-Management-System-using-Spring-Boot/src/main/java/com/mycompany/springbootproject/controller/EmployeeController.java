package com.mycompany.springbootproject.controller;

import com.mycompany.springbootproject.model.Employee;
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
@RequestMapping("employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/getall")
    @ApiOperation("Fetch All Employee Records")
    public List<Employee> getEmployees() {
        log.info("INSIDE getEmployees!!");
        return employeeService.getAll();
    }

    @ApiOperation("Save a New Employee Record!")
    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
        log.info("Inside Employee %s", employee);
        Employee cust = employeeService.addEmployee(employee);
        return new ResponseEntity<>(cust, HttpStatus.CREATED);
    }

    @ApiOperation("Get A Employee By ID")
    @GetMapping("/getbyid/{id}")
    public Employee fetchById(@PathVariable int id) {
        return employeeService.fetchById(id);
    }

    @ApiOperation("Update An Existing Employee")
    @PutMapping("/update/{id}")
    public void update(@PathVariable int id,@Valid @RequestBody Employee employee){
        log.info("Updating a employee!!");
        employeeService.udpateEmployee(id, employee);
    }

    @ApiOperation("Delete A Employee")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        log.info("Deleting a employee with id %d", id);
        employeeService.deleteEmployee(id);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

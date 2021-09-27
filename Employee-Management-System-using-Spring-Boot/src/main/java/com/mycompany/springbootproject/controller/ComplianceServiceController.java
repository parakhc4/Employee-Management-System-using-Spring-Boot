package com.mycompany.springbootproject.controller;

import com.mycompany.springbootproject.model.Compliance;
import com.mycompany.springbootproject.model.StatusReport;
import com.mycompany.springbootproject.service.ComplianceService;
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
@RequestMapping("compliance")
public class ComplianceServiceController {

    @Autowired
    private ComplianceService complianceService;

    @GetMapping("/getall")
    @ApiOperation("Fetch All Compliance Records")
    public List<Compliance> getDepartments() {
        log.info("INSIDE getDepartments");
        return complianceService.getAllRL();
    }

    @ApiOperation("Save a New Compliance Record.")
    @PostMapping("/create/compliance")
    public ResponseEntity<Compliance> createDepartment(@Valid @RequestBody Compliance compliance) {
        log.info("Inside Employee %s", compliance);
        Compliance comp = complianceService.createRL(compliance);
        return new ResponseEntity<>(comp, HttpStatus.CREATED);
    }

    @ApiOperation("Save a New Compliance Record.")
    @PostMapping("/create/status")
    public ResponseEntity<StatusReport> createDepartment(@Valid @RequestBody StatusReport statusReport) {
        log.info("Inside Employee %s", statusReport);
        StatusReport stat = complianceService.createStatusReport(statusReport);
        return new ResponseEntity<>(stat, HttpStatus.CREATED);
    }

}

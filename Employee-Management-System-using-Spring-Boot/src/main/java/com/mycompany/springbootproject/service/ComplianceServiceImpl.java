package com.mycompany.springbootproject.service;

import com.mycompany.springbootproject.model.Compliance;
import com.mycompany.springbootproject.model.StatusReport;
import com.mycompany.springbootproject.repository.ComplianceRepository;
import com.mycompany.springbootproject.repository.DepartmentRepository;
import com.mycompany.springbootproject.repository.StatusReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplianceServiceImpl implements ComplianceService{

    @Autowired
    private ComplianceRepository complianceRepository;
    @Autowired
    private StatusReportRepository statusReportRepository;

    @Override
    public Compliance createRL(Compliance compliance) {
        complianceRepository.save(compliance);
        return compliance;
    }

    @Override
    public List<Compliance> getAllRL() {
        return complianceRepository.findAll();
    }

    @Override
    public List<Compliance> getAllRL(int id) {
        return null;
    }

    @Override
    public StatusReport createStatusReport(StatusReport statusReport) {
        statusReportRepository.save(statusReport);
        return statusReport;
    }

    @Override
    public List<StatusReport> getAllStatusReport() {
        return null;
    }
}

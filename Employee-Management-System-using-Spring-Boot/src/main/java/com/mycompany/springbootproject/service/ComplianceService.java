package com.mycompany.springbootproject.service;

import com.mycompany.springbootproject.model.Compliance;
import com.mycompany.springbootproject.model.StatusReport;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ComplianceService {
    public Compliance createRL(Compliance compliance);

    public List<Compliance> getAllRL();

    public List<Compliance> getAllRL(int id);

    public StatusReport createStatusReport(StatusReport statusReport);

    public List<StatusReport> getAllStatusReport();

}

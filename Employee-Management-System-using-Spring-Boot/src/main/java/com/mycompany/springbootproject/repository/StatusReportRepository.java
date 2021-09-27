package com.mycompany.springbootproject.repository;

import com.mycompany.springbootproject.model.StatusReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusReportRepository extends JpaRepository<StatusReport,Integer> {
}

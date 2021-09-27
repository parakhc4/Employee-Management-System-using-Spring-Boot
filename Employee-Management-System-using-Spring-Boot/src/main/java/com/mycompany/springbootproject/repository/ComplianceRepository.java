package com.mycompany.springbootproject.repository;

import com.mycompany.springbootproject.model.Compliance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplianceRepository extends JpaRepository<Compliance,Integer> {
}

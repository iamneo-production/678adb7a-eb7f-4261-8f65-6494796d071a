package com.virtusa.patientdetailservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.virtusa.patientdetailservice.entity.PatientSymptomDetails;

@Repository
public interface PatientSymptomsDetailsRepo extends JpaRepository< PatientSymptomDetails, Integer> {
    
}


package com.virtusa.patientdetailservice.repository;

import com.virtusa.patientdetailservice.entity.PatientDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientDetailsRepo extends JpaRepository<PatientDetails,Integer> {
}
package com.virtusa.patientdetailservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.virtusa.patientdetailservice.entity.PatientDetails;
import com.virtusa.patientdetailservice.repository.PatientDetailsRepo;
import org.springframework.stereotype.Service;



@Service
public class PatientDetailService {

    @Autowired
    private PatientDetailsRepo patientDetailsRepo;

    private PatientDetails savePatientDetails(PatientDetails details)
    {
        return patientDetailsRepo.save(details);
    }

    private PatientDetails getPatientDetailsById(int patientId)
    {
        return patientDetailsRepo.getById(patientId);
    }
}

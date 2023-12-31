package com.virtusa.patientdetailservice.service;

import com.virtusa.patientdetailservice.entity.PatientDetails;
import com.virtusa.patientdetailservice.repository.PatientDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PatientDetailService {

@Autowired
private PatientDetailsRepo patientDetailsRepo;



public PatientDetails savePatientDetails(PatientDetails details)
{
return patientDetailsRepo.save(details);
}

public PatientDetails getPatientDetailsById(int patientId)
{
return patientDetailsRepo.findById(patientId).get();
}




}
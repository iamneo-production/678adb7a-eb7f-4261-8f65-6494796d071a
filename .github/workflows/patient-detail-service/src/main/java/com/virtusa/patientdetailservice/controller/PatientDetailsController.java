package com.virtusa.patientdetailservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import com.virtusa.patientdetailservice.entity.PatientDetails;

import com.virtusa.patientdetailservice.service.PatientDetailService;

@RestController
public class PatientDetailsController {

    @Autowired
    private PatientDetailService patientDetailService;

    @PostMapping("/savePatientDetails")
    private PatientDetails savePatientDetails( @RequestBody PatientDetails details)
    {
        return patientDetailService.savePatientDetails(details);
    }

    @GetMapping("/getPatientDetailsById/{id}")
    private PatientDetails getPatientDetailsById(@PathVariable("id") int patientId)
    {
        System.out.print(patientDetailService);
        return patientDetailService.getPatientDetailsById(patientId);
    }
    
}

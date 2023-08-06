package com.virtusa.patientdetailservice.controller;

import com.virtusa.patientdetailservice.entity.PatientDetails;
import com.virtusa.patientdetailservice.service.PatientDetailService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patientDetailAPI")
public class PatientDetailsController {

@Autowired
private PatientDetailService patientDetailsService;

@PostMapping("/savePatientDetails")
private PatientDetails savePatientDetails( @RequestBody PatientDetails details)
{
return patientDetailsService.savePatientDetails(details);
}

/* 
@ResponseStatus(HttpStatus.CONFLICT)
@CircuitBreaker(name ="patient",fallbackMethod = "fallBackMenthod")
@Retry(name = "patient")*/
@CircuitBreaker(name="clientBreaker",fallbackMethod = "getClientFallBack")
@GetMapping("/getPatientDetailsById/{id}")
public PatientDetails getPatientDetailsById(@PathVariable("id") int patientId)
{
return patientDetailsService.getPatientDetailsById(patientId);
}

public PatientDetails getClientFallBack(@PathVariable("id") int patientId,RuntimeException runtimeException)
{
return null;
}


}
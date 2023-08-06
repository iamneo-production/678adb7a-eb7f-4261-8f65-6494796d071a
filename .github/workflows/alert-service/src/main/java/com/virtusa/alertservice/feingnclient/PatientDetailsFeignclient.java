package com.virtusa.alertservice.feingnclient;

 import com.virtusa.alertservice.response.PatientDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value ="PATIENT-DETAIL-SERVICE",path ="/api/patientDetailAPI")
public interface PatientDetailsFeignclient {

    @GetMapping("/getPatientDetailsById/{id}")
    public PatientDetails getPatientDetailsById(@PathVariable("id") int patientId);
}

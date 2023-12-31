package com.virtusa.alertservice.controller;

import com.virtusa.alertservice.entity.HealthCareProviders;
import com.virtusa.alertservice.service.AlertService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/alertAPI")
@RestController
public class AlertController {

    @Autowired
    private AlertService alertService;

    @GetMapping("/alertPatient/{patientID}")
    @ResponseStatus(HttpStatus.CONFLICT)
    @CircuitBreaker(name ="alert",fallbackMethod = "circuitAlertFromHealthCareService")
    @Retry(name = "alert")
    public String alertFromHealthCareService( @PathVariable("patientID") int patientID)
    {
        System.out.println("entered alert service");
        return alertService.alertFromHealthCareService(patientID);

    }

    public String circuitAlertFromHealthCareService(@PathVariable("patientID") int providerID,RuntimeException runtimeException)
    {
        return "the service is down please try later";

    }

    @GetMapping("/getHealthCareProviderByID/{id}")
    @CircuitBreaker(name="clientBreaker",fallbackMethod = "getClientFallBack")
    public HealthCareProviders getHealthCarePoviderByID(@PathVariable("id") int providerID)
    {
        return alertService.getHealtCareProviderByID(providerID);
    }

    public HealthCareProviders getClientFallBack(@PathVariable("id") int providerID,RuntimeException runtimeException)
    {
        return null;
    }
}

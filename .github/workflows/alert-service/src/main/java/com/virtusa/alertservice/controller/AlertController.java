package com.virtusa.alertservice.controller;

import com.virtusa.alertservice.entity.HealthCareProviders;
 import com.virtusa.alertservice.service.AlertService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/alertAPI")
@RestController
public class AlertController {

    @Autowired
    private AlertService alertService;

//    @PostMapping("/alertPatient")
//     @ResponseStatus(HttpStatus.CONFLICT)
//    @CircuitBreaker(name ="alert",fallbackMethod = "circuitAlertFromHealthCareService")
//     @Retry(name = "alert")
//    public String alertFromHealthCareService(@RequestBody DeviceDataResponse deviceDataResponse)
//    {
//       return alertService.alertFromHealthCareService(deviceDataResponse);
//
//    }

    @GetMapping("/alertPatient/{patientID}")
    @ResponseStatus(HttpStatus.CONFLICT)
    @CircuitBreaker(name ="alert",fallbackMethod = "circuitAlertFromHealthCareService")
    @Retry(name = "alert")
    public String alertFromHealthCareService( @PathVariable("patientID") int providerID)
    {
        return alertService.alertFromHealthCareService(providerID);

    }

    public String circuitAlertFromHealthCareService(@PathVariable("patientID") int providerID,RuntimeException runtimeException)
    {
        return "the service is down please try later";

    }

    @GetMapping("/getHealthCareProviderByID/{id}")
    @ResponseStatus(HttpStatus.CONFLICT)
    @CircuitBreaker(name ="alert",fallbackMethod = "circuitGetHealthCarePoviderByID")
    @Retry(name = "alert")
    public HealthCareProviders getHealthCarePoviderByID(@PathVariable("id") int providerID)
    {
        return alertService.getHealtCareProviderByID(providerID);
    }

    public HealthCareProviders circuitGetHealthCarePoviderByID(@PathVariable("id") int providerID,RuntimeException runtimeException)
    {
        return null;
    }
}

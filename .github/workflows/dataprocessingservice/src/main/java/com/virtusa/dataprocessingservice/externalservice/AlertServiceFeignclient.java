package com.virtusa.dataprocessingservice.externalservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="ALERT-SERVICE",path = "/api/alertAPI")
public interface AlertServiceFeignclient {

    @GetMapping("/alertPatient/{patientID}")
    public String alertFromHealthCareService(@PathVariable("patientID") int patientID);


}

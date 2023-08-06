package com.virtusa.dataprocessingservice.externalservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="NOTIFICATION-SERVICE",path = "/api/notificationAPI")
public interface NotificationFeignClient {

    @GetMapping("/notification/{patientID}")
    public void notificationForPatient(@PathVariable("patientID") int patientID);


}

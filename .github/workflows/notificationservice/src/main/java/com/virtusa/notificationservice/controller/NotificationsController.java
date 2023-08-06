package com.virtusa.notificationservice.controller;

import com.virtusa.notificationservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notificationAPI")
public class NotificationsController {



@Autowired
private NotificationService notificationService;

@GetMapping("/notification/{patientID}")
public void notificationForPatient(@PathVariable("patientID") int patientID)
{
notificationService.alertFromHealthCareService(patientID);
}


}

package com.virtusa.notificationservice.service;

import com.virtusa.notificationservice.feingnclient.HealthCareProviderFeignClient;
import com.virtusa.notificationservice.response.HealthCareProviders;
import com.virtusa.notificationservice.feingnclient.PatientDetailsFeignclient;
import com.virtusa.notificationservice.response.PatientDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);


@Autowired
private PatientDetailsFeignclient patientDetailsFeignclient;

@Autowired
private HealthCareProviderFeignClient healthCareProviderFeignClient;



public void alertFromHealthCareService( int patientID)
{


try{
PatientDetails patientDetails = patientDetailsFeignclient.getPatientDetailsById(patientID);
HealthCareProviders healthCareProviders = healthCareProviderFeignClient.getHealthCarePoviderByID(patientDetails.getHealthProviderID());
logger.info("Notification for Patient");
logger.info("Phone number : "+patientDetails.getPhoneNo()+" ==>sms is sent health provider regarding your health condition based on details ");
logger.info("-----------------------------------------------------------------");
logger.info("To : "+patientDetails.getEmail());
logger.info("Subject : your health is at abnormal condition" );
logger.info("Body : your health condition is not in good condition. we have assigned to health care provider for the health checkup. ");
logger.info("Fallowing are health care Provider Details. ");
logger.info(" provider ID: "+healthCareProviders.getHealthCareID());
logger.info(" provider Email: "+healthCareProviders. getEmail());
logger.info(" provider phone Number: "+healthCareProviders.getPhoneNo());

}
catch (Exception e)
{
System.out.println("---------- "+e.getMessage());
}
}



}
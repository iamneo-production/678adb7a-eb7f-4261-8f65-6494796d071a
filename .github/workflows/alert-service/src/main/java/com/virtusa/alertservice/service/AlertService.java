package com.virtusa.alertservice.service;

import com.virtusa.alertservice.entity.HealthCareProviders;
import com.virtusa.alertservice.feingnclient.PatientDetailsFeignclient;
import com.virtusa.alertservice.repository.HealthCareProviderRepo;
import com.virtusa.alertservice.response.PatientDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlertService {

    private static final Logger logger = LoggerFactory.getLogger(AlertService.class);


    @Autowired
    private PatientDetailsFeignclient patientDetailsFeignclient;

    @Autowired
    private HealthCareProviderRepo healthCareProviderRepo;

    public String alertFromHealthCareService( int  patientID)
    {
        try{
            PatientDetails patientDetails   =  patientDetailsFeignclient.getPatientDetailsById(patientID);
            HealthCareProviders healthCareProviders = getHealtCareProviderByID(patientDetails.getHealthProviderID());
            logger.info("health care provider");
            logger.info("Phone number : "+healthCareProviders.getPhoneNo()+" ==>sms is sent health provider regarding your health condition based on details ");
            logger.info("-----------------------------------------------------------------");
            logger.info("To : "+healthCareProviders.getEmail());
            logger.info("Subject : abnormal condition for the patient with the id - "+patientID );
            logger.info("Body : please look in to above patient he is in abnormal condition");

        }
        catch (Exception e)
        {
            logger.info("---------- "+e.getMessage());
        }
        return "";
    }

    public HealthCareProviders getHealtCareProviderByID(int providerID)
    {
        return healthCareProviderRepo.findById(providerID).get();
    }

}


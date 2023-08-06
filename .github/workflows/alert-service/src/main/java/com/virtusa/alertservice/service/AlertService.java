package com.virtusa.alertservice.service;

import com.virtusa.alertservice.entity.HealthCareProviders;
import com.virtusa.alertservice.feingnclient.PatientDetailsFeignclient;
import com.virtusa.alertservice.repository.HealthCareProviderRepo;
import com.virtusa.alertservice.response.PatientDetailsResponse;
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
        PatientDetailsResponse patientDetails = null;


        try{
            patientDetails   =  patientDetailsFeignclient.getPatientDetailsById(patientID);
            HealthCareProviders healthCareProviders = getHealtCareProviderByID(patientDetails.getHealthProviderID());
             //logger.info(patientDetails.toString());
            logger.info("health care provider");
            logger.info("Phone number : "+healthCareProviders.getPhoneNo()+" ==>sms is sent health provider regarding your health condition based on details ");
            logger.info("-----------------------------------------------------------------");
            logger.info("To : "+healthCareProviders.getEmail());
            logger.info("Subject : abnormal condition for the patient with the id - "+patientID );
            logger.info("Body : ");

        }
        catch (Exception e)
        {
            System.out.println("---------- "+e.getMessage());
        }
        return (patientDetails!=null)? patientDetails.toString():"no data found";
    }

//    public String alertFromHealthCareService(DeviceDataResponse deviceDataResponse)
//    {
//        PatientDetailsResponse patientDetails = null;
//
//
//       try{
//           patientDetails   =  patientDetailsFeignclient.getPatientDetailsById(deviceDataResponse.getPatientId());
//           HealthCareProvidersResponse health =  patientDetailsFeignclient.getHealthCarePoviderByID(deviceDataResponse.getHealthCareId());
//            //logger.info(patientDetails.toString());
//           logger.info("health care provider");
//           logger.info("Phone number : "+health.getPhoneNo()+" ==>sms is sent your phone number regarding your health condition based on details ");
//           logger.info("-----------------------------------------------------------------");
//           logger.info("To : "+health.getEmail());
//           logger.info("Subject : abnormal condition for the patient with the id - "+deviceDataResponse.getPatientId() );
//           logger.info("Body : ");
//
//       }
//       catch (Exception e)
//       {
//           System.out.println("---------- "+e.getMessage());
//       }
//     return (patientDetails!=null)? patientDetails.toString():"no data found";
//    }

    public HealthCareProviders getHealtCareProviderByID(int providerID)
    {
        return healthCareProviderRepo.findById(providerID).get();
    }

}


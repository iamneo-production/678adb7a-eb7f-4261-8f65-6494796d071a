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
        //PatientDetailsResponse patientDetails = null;


        try{
            System.out.println("asking patient details");
            PatientDetails patientDetails   =  patientDetailsFeignclient.getPatientDetailsById(patientID);
            System.out.println("received patient details");
            HealthCareProviders healthCareProviders = getHealtCareProviderByID(patientDetails.getHealthProviderID());
            if(healthCareProviders==null)
                System.out.println("health care is null");
            System.out.println("got health care details");
             //logger.info(patientDetails.toString());
            logger.info("health care provider");
            logger.info("Phone number : "+healthCareProviders.getPhoneNo()+" ==>sms is sent health provider regarding your health condition based on details ");
            logger.info("-----------------------------------------------------------------");
            logger.info("To : "+healthCareProviders.getEmail());
            logger.info("Subject : abnormal condition for the patient with the id - "+patientID );
            logger.info("Body : please look in to above patient he is in abnormal condition");

        }
        catch (Exception e)
        {
            System.out.println("---------- "+e.getMessage());
        }
        //return (patientDetails!=null)? patientDetails.toString():"no data found";
        return "error 0";
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
        System.out.println("method called");
        return healthCareProviderRepo.findById(providerID).get();
    }

}


package com.virtusa.alertservice.response;

import lombok.Data;
import lombok.NoArgsConstructor;
 
@Data
@NoArgsConstructor
public class PatientDetailsResponse {

    private int patientId;
    private String username;
    private String password;
    private String fullName;
    private long phoneNo;
    private String email;
    private String address;
    private int healthProviderID;

    
}

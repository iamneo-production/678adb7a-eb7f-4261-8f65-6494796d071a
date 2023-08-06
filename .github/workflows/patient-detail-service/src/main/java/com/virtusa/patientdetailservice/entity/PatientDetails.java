package com.virtusa.patientdetailservice.entity;

import java.lang.annotation.Inherited;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import lombok.Data;
import lombok.NoArgsConstructor;
 

@Entity
@Data
@NoArgsConstructor
public class PatientDetails {

    @Id
    @GeneratedValue
    private int patientId;
    private String username;
    private String password;
    private String fullName;
    private long phoneNo;
    private String email;
    private String address;
    private int healthProviderID;
    
}

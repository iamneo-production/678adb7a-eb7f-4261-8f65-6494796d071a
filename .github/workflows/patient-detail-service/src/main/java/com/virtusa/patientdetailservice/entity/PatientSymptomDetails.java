package com.virtusa.patientdetailservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import lombok.Data;
import lombok.NoArgsConstructor;
 

@Entity
@Data
@NoArgsConstructor
public class PatientSymptomDetails {

    @Id
    @GeneratedValue
    private int enrollId;
    private int patientId;
    private String sympotms;
    private int daysOfOccuranceOfSymptoms;
    private String description;
    
}

package com.virtusa.alertservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import lombok.Data;
import lombok.NoArgsConstructor;
 

@Entity
@Data
@NoArgsConstructor
public class HealthCareProviders {

    @Id
    @GeneratedValue
    private int healthCareID;
    private String email;
    private long phoneNo;

    
}

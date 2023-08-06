package com.virtusa.alertservice.repository;

 import com.virtusa.alertservice.entity.HealthCareProviders;
 import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthCareProviderRepo extends JpaRepository<HealthCareProviders,Integer> {
}


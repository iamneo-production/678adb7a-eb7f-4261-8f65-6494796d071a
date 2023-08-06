package com.virtusa.notificationservice.feingnclient;

import com.virtusa.notificationservice.response.HealthCareProviders;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

@FeignClient(value ="ALERT-SERVICE", path = "api/alertAPI")
public interface HealthCareProviderFeignClient {

@GetMapping("/getHealthCareProviderByID/{id}")
public HealthCareProviders getHealthCarePoviderByID(@PathVariable("id") int providerID);
}

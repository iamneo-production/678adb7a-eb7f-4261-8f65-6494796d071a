package com.virtusa.devicegatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DevicegatewayserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevicegatewayserviceApplication.class, args);
	}

}

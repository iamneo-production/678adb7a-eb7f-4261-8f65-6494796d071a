package com.virtusa.devicegatewayservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.devicegatewayservice.entity.Device;
import com.virtusa.devicegatewayservice.dto.DeviceData;
import com.virtusa.devicegatewayservice.externalservice.DataProcessingService;
import com.virtusa.devicegatewayservice.service.DeviceService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/device")
public class DeviceController {
	
	@Autowired
	DeviceService deviceservice;
	
	@Autowired
	DataProcessingService dataprocessingservice;
	
	@PostMapping("/addDevice")
	public String addDevice(@RequestBody Device device)
	{
		return deviceservice.addDevice(device);
	}
	
	@CircuitBreaker(name="clientBreaker",fallbackMethod = "getClientFallBack")
	@PostMapping("/sendData")
	public String sendData(@RequestBody DeviceData devicedata)
	{
		return dataprocessingservice.dataProcessing(devicedata);
	}
	
	public String getClientFallBack(Exception e) {
        return "Default message";
   }
}


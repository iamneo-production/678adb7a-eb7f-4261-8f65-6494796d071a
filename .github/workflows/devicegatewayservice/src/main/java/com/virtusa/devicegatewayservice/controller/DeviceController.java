package com.virtusa.devicegatewayservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import com.virtusa.devicegatewayservice.entity.Device;
import com.virtusa.devicegatewayservice.dto.DeviceData;
import com.virtusa.devicegatewayservice.externalservice.DataProcessingService;
import com.virtusa.devicegatewayservice.service.DeviceService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/api/device")
public class DeviceController {

	private static final Logger logger = LoggerFactory.getLogger(DeviceController.class);
	
	@Autowired
	DeviceService deviceService;
	
	@Autowired
	DataProcessingService dataProcessingService;
	
	@PostMapping("/addDevice")
	public Device addDevice(@RequestBody Device device)
	{
		return deviceService.addDevice(device);
	}
	
	@CircuitBreaker(name="clientBreaker",fallbackMethod = "getClientFallBack")
	@PostMapping("/device-gateway")
	public void sendData(@RequestBody DeviceData devicedata)
	{
		dataProcessingService.dataProcessing(devicedata);
	}

	@GetMapping("/getById/{id}")
	public Device getById(@PathVariable("id") int id)
	{
		return deviceService.findById(id).get();
	}
	
	public void getClientFallBack(Exception e) {
		logger.info("data processing client is down");
   }
}


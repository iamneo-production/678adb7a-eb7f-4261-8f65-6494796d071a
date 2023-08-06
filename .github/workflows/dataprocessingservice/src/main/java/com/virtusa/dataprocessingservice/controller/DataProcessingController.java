package com.virtusa.dataprocessingservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.dataprocessingservice.dto.DeviceData;
import com.virtusa.dataprocessingservice.entity.DataManual;
import com.virtusa.dataprocessingservice.service.DataProcessingService;

@RestController
public class DataProcessingController {
	
	@Autowired
	DataProcessingService dataprocessingservice;
	
	@PostMapping("/addtoManual")
	public DataManual addToManual(@RequestBody DataManual datamanual)
	{
		return dataprocessingservice.addToManual(datamanual);
	}
	
	@PostMapping("/data-processing")
	public String dataProcessing(@RequestBody DeviceData devicedata)
	{
		return dataprocessingservice.dataProcessing(devicedata);
	}

}
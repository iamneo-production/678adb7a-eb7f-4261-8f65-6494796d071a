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
@RequestMapping("/api/data")
public class DataProcessingController {
	
	@Autowired
	DataProcessingService dataProcessingService;
	
	@PostMapping("/addtoManual")
	public DataManual addToManual(@RequestBody DataManual datamanual)
	{
		return dataProcessingService.addToManual(datamanual);
	}
	
	@PostMapping("/data-processing")
	public void dataProcessing(@RequestBody DeviceData devicedata)
	{
		dataProcessingService.dataProcessing(devicedata);
	}

}
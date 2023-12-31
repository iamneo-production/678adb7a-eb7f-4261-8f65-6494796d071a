package com.virtusa.devicegatewayservice.externalservice;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.virtusa.devicegatewayservice.dto.DeviceData;
import com.virtusa.devicegatewayservice.entity.Device;

@FeignClient(name="DATA-PROCESSING-SERVICE",path = "/api/data")
public interface DataProcessingService {
	
	
	@PostMapping("/data-processing")
	public String dataProcessing(@RequestBody DeviceData devicedata);
	

}

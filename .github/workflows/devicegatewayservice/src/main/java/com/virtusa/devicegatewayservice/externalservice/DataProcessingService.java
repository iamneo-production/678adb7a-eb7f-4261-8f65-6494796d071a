package com.virtusa.devicegatewayservice.externalservice;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.virtusa.devicegatewayservice.dto.DeviceData;

@FeignClient(name="DATA-PROCESSING-SERVICE")
public interface DataProcessingService {
	
	
	@PostMapping("/data-processing")
	public String dataProcessing(@RequestBody DeviceData devicedata);
	

}

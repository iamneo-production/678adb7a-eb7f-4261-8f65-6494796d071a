package com.virtusa.dataprocessingservice.externalservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.virtusa.dataprocessingservice.dto.Device;

@FeignClient(name="DEVICE-GATEWAY-SERVICE",path = "/api/device")
public interface DeviceFeignClient {

    @GetMapping("/getById/{id}")
	public Device getById(@PathVariable("id") int id);


}
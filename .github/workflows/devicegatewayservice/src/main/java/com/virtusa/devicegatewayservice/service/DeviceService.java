package com.virtusa.devicegatewayservice.service;
import com.virtusa.devicegatewayservice.entity.Device;

import java.util.Optional;

public interface DeviceService {
	public Device addDevice(Device device);
	public Optional<Device> findById(int id);
	
}
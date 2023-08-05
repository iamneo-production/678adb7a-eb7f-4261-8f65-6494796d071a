package com.virtusa.devicegatewayservice.serviceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.virtusa.devicegatewayservice.entity.Device;
import com.virtusa.devicegatewayservice.repo.DeviceRepo;
import com.virtusa.devicegatewayservice.service.DeviceService;

@Service
public class DeviceServiceImpl implements DeviceService{
	
	@Autowired
	DeviceRepo devicerepo;

	@Override
	public String addDevice(Device device) {
		devicerepo.save(device);
		return "Device added";
	}

}
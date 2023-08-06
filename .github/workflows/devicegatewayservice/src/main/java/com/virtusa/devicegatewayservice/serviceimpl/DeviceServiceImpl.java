package com.virtusa.devicegatewayservice.serviceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.virtusa.devicegatewayservice.entity.Device;
import com.virtusa.devicegatewayservice.repo.DeviceRepo;
import com.virtusa.devicegatewayservice.service.DeviceService;
import java.util.Optional;
@Service
public class DeviceServiceImpl implements DeviceService{
	
	@Autowired
	DeviceRepo deviceRepo;

	@Override
	public Device addDevice(Device device) {
		return deviceRepo.save(device);
	}

	@Override
	public Optional<Device> findById(int id)
	{
		return deviceRepo.findById(id);
	}

}
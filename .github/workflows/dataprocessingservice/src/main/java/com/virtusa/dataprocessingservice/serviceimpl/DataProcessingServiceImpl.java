package com.virtusa.dataprocessingservice.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.dataprocessingservice.dto.DeviceData;
import com.virtusa.dataprocessingservice.dto.Params;
import com.virtusa.dataprocessingservice.entity.DataManual;
import com.virtusa.dataprocessingservice.exception.DataProcessException;
import com.virtusa.dataprocessingservice.repo.DataProcessingRepo;
import com.virtusa.dataprocessingservice.service.DataProcessingService;
import com.virtusa.dataprocessingservice.externalservice.AlertServiceFeignclient;
import com.virtusa.dataprocessingservice.externalservice.NotificationFeignClient;
import com.virtusa.dataprocessingservice.externalservice.DeviceFeignClient;
import com.virtusa.dataprocessingservice.dto.Device;
import java.util.*;

@Service
public class DataProcessingServiceImpl implements DataProcessingService{
	
	@Autowired
	DataProcessingRepo dataProcessingRepo;

	@Autowired
	AlertServiceFeignclient alertServiceFeignClient;

	@Autowired
	NotificationFeignClient notificationFeignClient;

	@Autowired
	DeviceFeignClient deviceFeignClient;

	@Override
	public DataManual addToManual(DataManual datamanual) {
		return dataProcessingRepo.save(datamanual);
	}

	public void dataProcessing(DeviceData devicedata) throws DataProcessException{
		try {
		Device dt1=deviceFeignClient.getById(devicedata.getDeviceId());
		List<DataManual> dt=dataProcessingRepo.findByDeviceType(dt1.getType());
		for(DataManual obj1:dt)
		{
		for(Params obj:devicedata.getParams())
		{
			if((obj1.getParamName()).equals(obj.getName()))
			{
			if(obj.getValue()<(int)(obj1.getMinimum()) ||obj.getValue()>(int)(obj1.getMaximum()))
			{
				System.out.println("enterede 2");
				notificationFeignClient.notificationForPatient(devicedata.getPatientId());
				alertServiceFeignClient.alertFromHealthCareService(devicedata.getPatientId());
				break;
			}
		}
		}

		}
		}
		catch(RuntimeException e) {
			throw new DataProcessException("Error occured when processing the data");
		}
	}


}


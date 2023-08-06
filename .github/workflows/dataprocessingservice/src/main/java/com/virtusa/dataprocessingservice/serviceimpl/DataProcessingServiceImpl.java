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
@Service
public class DataProcessingServiceImpl implements DataProcessingService{
	
	@Autowired
	DataProcessingRepo dataProcessingRepo;

	@Autowired
	AlertServiceFeignclient alertServiceFeignClient;

	@Autowired
	NotificationFeignClient notificationFeignClient;

	@Override
	public DataManual addToManual(DataManual datamanual) {
		return dataProcessingRepo.save(datamanual);
	}

	@Override
	public void dataProcessing(DeviceData devicedata) throws DataProcessException{
		try {
			devicedata.getParams();
		for(Params obj:devicedata.getParams())
		{
			DataManual datamanual=dataProcessingRepo.findByParamName(obj.getName());
			if(obj.getValue()<(int)(datamanual.getMinimum()) ||obj.getValue()>(int)(datamanual.getMaximum()))
			{
				notificationFeignClient.notificationForPatient(devicedata.getPatientId());
				alertServiceFeignClient.alertFromHealthCareService(devicedata.getPatientId());
				break;
			}
		}
		}
		catch(RuntimeException e) {
			throw new DataProcessException("Error occured when processing the data");
		}
	}
}


package com.virtusa.dataprocessingservice.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.dataprocessingservice.dto.DeviceData;
import com.virtusa.dataprocessingservice.dto.Params;
import com.virtusa.dataprocessingservice.entity.DataManual;
import com.virtusa.dataprocessingservice.exception.ParamsNotFoundException;
import com.virtusa.dataprocessingservice.repo.DataProcessingRepo;
import com.virtusa.dataprocessingservice.service.DataProcessingService;
import com.virtusa.dataprocessingservice.externalservice.AlertServiceFeignclient;

@Service
public class DataProcessingServiceImpl implements DataProcessingService{
	
	@Autowired
	DataProcessingRepo dataprocessingrepo;

	@Autowired
	AlertServiceFeignclient alertservicefeignclient;

	@Override
	public DataManual addToManual(DataManual datamanual) {
		return dataprocessingrepo.save(datamanual);
	}

	@Override
	public void dataProcessing(DeviceData devicedata) throws ParamsNotFoundException{
		try {
			devicedata.getParams();
		for(Params obj:devicedata.getParams())
		{
			DataManual datamanual=dataprocessingrepo.findByParamName(obj.getName());
			System.out.println(datamanual.getMaximum()+"naveen"+datamanual.getMinimum());
			System.out.println(obj.getValue());
			if(obj.getValue()<(int)(datamanual.getMinimum()) ||obj.getValue()>(int)(datamanual.getMaximum()))
			{
				System.out.println("entered");
				alertservicefeignclient.alertFromHealthCareService(devicedata.getPatientId());
				System.out.println("hii");
				break;
			}
		}
		}
		//catch all exceptions
		catch(RuntimeException e) {
			throw new ParamsNotFoundException("Required Params not Found");
		}
	}
}


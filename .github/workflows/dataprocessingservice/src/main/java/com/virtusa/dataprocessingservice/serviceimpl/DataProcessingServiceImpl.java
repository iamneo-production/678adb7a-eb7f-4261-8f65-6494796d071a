package com.virtusa.dataprocessingservice.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.dataprocessingservice.dto.DeviceData;
import com.virtusa.dataprocessingservice.dto.Params;
import com.virtusa.dataprocessingservice.entity.DataManual;
import com.virtusa.dataprocessingservice.exception.ParamsNotFoundException;
import com.virtusa.dataprocessingservice.repo.DataProcessingRepo;
import com.virtusa.dataprocessingservice.service.DataProcessingService;

@Service
public class DataProcessingServiceImpl implements DataProcessingService{
	
	@Autowired
	DataProcessingRepo dataprocessingrepo;

	@Override
	public DataManual addToManual(DataManual datamanual) {
		return dataprocessingrepo.save(datamanual);
	}

	@Override
	public String dataProcessing(DeviceData devicedata) throws ParamsNotFoundException{
		try {
			devicedata.getParams();
		for(Params obj:devicedata.getParams())
		{
			DataManual datamanual=dataprocessingrepo.findByParamName(obj.getName());
			if(obj.getValue()<datamanual.getMinimum() || obj.getValue()>datamanual.getMaximum())
			{
				return "Abnormal";
			}
		}
		}
		catch(RuntimeException e) {
			throw new ParamsNotFoundException("Required Params not Found");
		}
		return "Normal";
	}
}


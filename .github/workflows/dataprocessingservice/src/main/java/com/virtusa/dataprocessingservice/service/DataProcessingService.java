package com.virtusa.dataprocessingservice.service;

import com.virtusa.dataprocessingservice.dto.DeviceData;
import com.virtusa.dataprocessingservice.entity.DataManual;

public interface DataProcessingService {
	public String addToManual(DataManual datamanual);
	public String dataProcessing(DeviceData device);
}

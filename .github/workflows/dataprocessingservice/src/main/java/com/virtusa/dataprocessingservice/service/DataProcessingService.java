package com.virtusa.dataprocessingservice.service;

import com.virtusa.dataprocessingservice.dto.DeviceData;
import com.virtusa.dataprocessingservice.entity.DataManual;
import com.virtusa.dataprocessingservice.dto.Device;

public interface DataProcessingService {
	public DataManual addToManual(DataManual datamanual);
	public void dataProcessing(DeviceData devicedata);
}

package com.virtusa.dataprocessingservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.dataprocessingservice.entity.DataManual;

import java.util.*;

public interface DataProcessingRepo extends JpaRepository<DataManual,Integer>{

	DataManual findByParamName(String name);
	List<DataManual> findByDeviceType(String deviceType);

}
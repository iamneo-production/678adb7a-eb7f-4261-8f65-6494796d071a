package com.virtusa.devicegatewayservice.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import com.virtusa.devicegatewayservice.entity.Device;


public interface DeviceRepo extends JpaRepository<Device, Integer>{

}

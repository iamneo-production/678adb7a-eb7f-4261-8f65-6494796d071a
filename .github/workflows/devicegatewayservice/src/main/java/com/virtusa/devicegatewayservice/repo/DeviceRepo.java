package com.virtusa.devicegatewayservice.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import com.virtusa.devicegatewayservice.entity.Device;
import java.util.*;


public interface DeviceRepo extends JpaRepository<Device, Integer>{
    public Optional<Device> findById(int id);
}

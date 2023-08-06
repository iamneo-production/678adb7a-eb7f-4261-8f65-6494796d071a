package com.virtusa.dataprocessingservice.dto;

public class Device {
	
	public Device()
	{
		super();
	}
	
	public Device(int deviceId, String type, String description) {
		super();
		this.deviceId = deviceId;
		this.type = type;
		this.description = description;
	}
	public int getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	private int deviceId;
	private String type;
	private String description;
}


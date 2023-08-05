package com.virtusa.devicegatewayservice.dto;
import java.util.List;

public class DeviceData {
	public DeviceData() {
		super();
	}
	public DeviceData(int deviceId, int patientId, List<Params> params) {
		super();
		this.deviceId = deviceId;
		this.patientId = patientId;
		this.params = params;
	}
	public int getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public List<Params> getParams() {
		return params;
	}
	public void setParams(List<Params> params) {
		this.params = params;
	}
	private int deviceId;
	private int patientId;
	private List<Params> params;
}


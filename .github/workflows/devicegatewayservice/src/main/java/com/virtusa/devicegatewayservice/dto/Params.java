package com.virtusa.devicegatewayservice.dto;

public class Params {
	public Params() {
		super();
	}
	public Params(String name, int value) {
		super();
		this.name = name;
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	private String name;
	private int value;
}


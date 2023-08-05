package com.virtusa.dataprocessingservice.exception;

public class ParamsNotFoundException extends RuntimeException {

	public ParamsNotFoundException() {
		super();
	}

	public ParamsNotFoundException(String message) {
		super(message);
	}
}

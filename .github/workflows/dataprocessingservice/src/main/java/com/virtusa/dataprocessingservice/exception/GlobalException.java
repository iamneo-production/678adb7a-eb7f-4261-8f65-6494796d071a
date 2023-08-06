package com.virtusa.dataprocessingservice.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(DataProcessException.class)
	public String handleParamsNotFoundException(DataProcessException e) {
		return e.getMessage();
	}
}

package com.virtusa.dataprocessingservice.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(ParamsNotFoundException.class)
	public String handleParamsNotFoundException(ParamsNotFoundException e) {
		return e.getMessage();
	}
}

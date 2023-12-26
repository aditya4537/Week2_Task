package com.example.userdemo.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.userdemo.Exception.DoctorNotFoundException;
import com.example.userdemo.dto.ResponseDto;

@RestControllerAdvice
public class CustomException {
	
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(DoctorNotFoundException.class)
	public ResponseDto customException(DoctorNotFoundException ex) {
		return new ResponseDto(404, "Not Found", ex.getMessage());
	}
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(Exception.class)
	public ResponseDto customException1(Exception ex) {
		return new ResponseDto(405, "Not Found", ex.getMessage());
	}
}

package com.sunil.stock.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StockNameExceptionHandler {
	
	@ExceptionHandler(value= StockNameNotFoundException.class)
	public ResponseEntity<ApiError> handleStockNotFoundException() {
		ApiError error = new ApiError(400, "Stock Not Found", new Date());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}

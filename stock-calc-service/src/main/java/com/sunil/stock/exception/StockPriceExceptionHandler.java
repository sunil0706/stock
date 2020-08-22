package com.sunil.stock.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StockPriceExceptionHandler {

	@ExceptionHandler(value= StockPriceNotFoundException.class)
	public ResponseEntity<ApiError> handleStockPriceNotFoundException() {
		ApiError error = new ApiError(400, "Stock Price Not Found", new Date());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}

package com.sunil.stock.exception;

public class StockNameNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -296150922808281997L;

	public StockNameNotFoundException(String message) {
		super(message);
	}
	
}

package com.sunil.stock.exception;

public class StockPriceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 7471768278073162270L;
	
	public StockPriceNotFoundException(String message) {
		super(message);
	}

}

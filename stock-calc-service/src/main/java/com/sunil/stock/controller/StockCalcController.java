package com.sunil.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sunil.stock.fiegnclient.ProxyStock;

@RestController
public class StockCalcController {
	
	@Autowired
	private ProxyStock stock;
	
	@GetMapping("/stockprice/{quantity}/{stockName}")
	public ResponseEntity<String> findStockCalculate(@PathVariable Integer quantity,@PathVariable String stockName) {
		Double totalStockPrice = null;
		ResponseEntity<Double> responseStatus = stock.getStockPrice(stockName);
		Double stockPrice = responseStatus.getBody().doubleValue();
		if(responseStatus.getStatusCode().value()==200) {
			totalStockPrice = quantity * stockPrice;
		System.out.println("Total Stock Price of "+quantity+" unit "+stockName+" is : "+totalStockPrice);
		return new ResponseEntity<String>("Total Price ::"+totalStockPrice, HttpStatus.OK);
		}
		return new ResponseEntity<String>("Stock Not Found",HttpStatus.BAD_REQUEST);
	}
}

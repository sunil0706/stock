package com.sunil.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunil.stock.fiegnclient.ProxyStock;

@RestController
@RequestMapping("/calculation")
public class StockCalcController {
	
	@Autowired
	private ProxyStock stock;
	
	@GetMapping("/stockprice/{stockName}/{quantity}")
	public ResponseEntity<?> findStockCalculate(@PathVariable String stockName,@PathVariable Integer quantity) {
		Double totalStockPrice = null;
		ResponseEntity<?> resEntity = null;
		try {
		resEntity = stock.getStockPrice(stockName);
		Double stockPrice = ((Double) resEntity.getBody()).doubleValue();
		
		if(resEntity.getStatusCode().value()==200) {
			totalStockPrice = quantity * stockPrice;
		System.out.println("Total Stock Price of "+quantity+" unit "+stockName+" is : "+totalStockPrice);
		return new ResponseEntity<String>("Total Stock Price is :: "+totalStockPrice, HttpStatus.OK);
		}
		}
		catch(Exception e) {
			resEntity = new ResponseEntity<String>("Stock Name Not Found",HttpStatus.BAD_REQUEST);
		}
		return resEntity;
	}
}

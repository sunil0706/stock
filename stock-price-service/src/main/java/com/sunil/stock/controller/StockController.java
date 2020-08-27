package com.sunil.stock.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunil.stock.model.Stock;
import com.sunil.stock.service.StockService;

@RestController
@RequestMapping("/stock")
public class StockController {

	@Autowired
	private StockService stockService;
	
	@GetMapping("/price/{stockName}")
	public ResponseEntity<Double> findStockPriceByName(@PathVariable("stockName") String stockName){
		Stock stock = stockService.findStockPrice(stockName);
		System.out.println("Stock Name : "+stockName+", Price : "+stock.getStockPrice());
		return new ResponseEntity<>(stock.getStockPrice(),HttpStatus.OK);
	}
}

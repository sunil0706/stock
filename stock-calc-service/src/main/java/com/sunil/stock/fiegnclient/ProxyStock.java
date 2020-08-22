package com.sunil.stock.fiegnclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sunil.stock.exception.StockPriceNotFoundException;


@FeignClient(name="stock-price-service")
public interface ProxyStock {

	@GetMapping("/price/{stockName}")
	public ResponseEntity<Double> getStockPrice(@PathVariable("stockName") String stockName) throws StockPriceNotFoundException;
}

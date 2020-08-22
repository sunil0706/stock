package com.sunil.stock.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunil.stock.exception.StockNameNotFoundException;
import com.sunil.stock.model.Stock;
import com.sunil.stock.repository.StockRepository;

@Service
public class StockServiceImpl implements StockService{
	
	private static final Logger logger = LoggerFactory.getLogger(StockServiceImpl.class);
	
	@Autowired
	private StockRepository stockRepository;
	
	@Override
	public Stock findStockPrice(String name) {
		logger.info("Inside StockServiceImpl class of findStockPrice");
		
		Stock stockObject = stockRepository.findStockPriceByStockName(name);
		if(stockObject==null) {
			throw new StockNameNotFoundException("Stock not found");
		}
		logger.info("Price in stockerService : "+stockObject.getStockPrice());
		logger.info("Outside StockServiceImpl class of findStockPrice");
		return stockObject;
	}

}

package com.sunil.stock.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class StockUIService {

	private final String REST_ENDPOINT="http://localhost:9092/calculation/stockprice/{stockName}/{quantity}";

    public String getTotalStockPrice(String stockName, Integer quantity) {
    	WebClient webclient = WebClient.create();
    	String response = null;
    	try {
    	response = webclient.get().uri(REST_ENDPOINT, stockName, quantity)
    						.retrieve().bodyToMono(String.class).block();
    		return response;
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		System.out.println("Stock Name Not Found");
    	}
    	return response;
    }
    
    
}

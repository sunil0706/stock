package com.sunil.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sunil.stock.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long>{
	
	//@Query(value = "SELECT stockPrice from Stock where stockName= :name")
	public Stock findStockPriceByStockName(String name);
}
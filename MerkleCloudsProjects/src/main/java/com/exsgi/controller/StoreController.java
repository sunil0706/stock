/**
 * 
 */
package com.exsgi.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.exsgi.api.Store;
import com.exsgi.api.StoreServiceImpl;
import com.exsgi.exception.StoreNotfoundException;

/**
 * @author SUNIL NAYAK
 *
 */
@RestController
@Validated
public class StoreController {
	
	private static Logger logger = LoggerFactory.getLogger(StoreController.class);
	
	@Autowired
	private StoreServiceImpl storeService;
	
	@PostMapping
	@RequestMapping("/store")
	public ResponseEntity<Store> saveShopDetails(@Valid @RequestBody Store store){
		logger.info("Inside createShop Controller method...");
		storeService.saveStore(store);
		logger.info("Outside createShop Controller method...");
		return new ResponseEntity<> (HttpStatus.CREATED);
	}
	
	@GetMapping
	@RequestMapping("/findAllStores")
	@ResponseBody
	public List<Store> findAllStores(){
		logger.info("Inside getAllStore method...");
		List<Store> stores = storeService.findAll();
		return stores;
	}
	
	 @GetMapping
	 @RequestMapping("/stores/{id}")
	 public Store findStore(@PathVariable Long id) {
		 Store store = null;
		 logger.info("Inside findStore controller method...");
		 	if(id !=null) {	
	        store = storeService.findById(id).orElseThrow(() -> new StoreNotfoundException());
		 	}
		 	return store;
	    }
}

/**
 * 
 */
package com.exsgi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.exsgi.api.Store;
import com.exsgi.api.Toy;
import com.exsgi.api.ToyServiceImpl;
import com.exsgi.exception.ToyNotfoundException;

/**
 * @author SUNIL NAYAK
 *
 */
@RestController
public class ToyContoller {
	
	private static Logger logger = LoggerFactory.getLogger(ToyContoller.class);
	
	@Autowired
	private ToyServiceImpl toyService;
	
	@PostMapping
	@RequestMapping("/toy")
	public ResponseEntity<Store> saveShopDetails(@RequestBody Toy toy){
		logger.info("Inside createToy Controller method...");
		toyService.saveToyDetails(toy);
		logger.info("Outside createtoy Controller method...");
		return new ResponseEntity<> (HttpStatus.CREATED);
	}
	
	@GetMapping
	@RequestMapping("/findAllToys")
	@ResponseBody
	public List<Toy> findAllToys(){
		logger.info("Inside getAllStore method...");
		List<Toy> toys = toyService.findAll();
		return toys;
	}
	
	@GetMapping
	 @RequestMapping("/toys/{id}")
	
	 public Toy findToy(@PathVariable Long id) {
		Toy toy = null;
		logger.info("Inside findToy controller method...");
		 
		 	if(id !=null) {	
		 	logger.info("Toy id before" +id);	
	        toy = toyService.findById(id).orElseThrow(() -> new ToyNotfoundException());
	        logger.info("Toy id " +id);
		 	}
		 	return toy;
	    }
}

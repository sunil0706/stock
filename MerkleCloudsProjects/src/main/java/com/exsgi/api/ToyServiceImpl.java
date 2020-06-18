/**
 * 
 */
package com.exsgi.api;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author SUNIL NAYAK
 *
 */
@Service
public class ToyServiceImpl implements ToyService{
	private static Logger logger = LoggerFactory.getLogger(ToyServiceImpl.class);
	
	@Autowired
	private ToyRepository toyRepository;
	
	@Override
	public void saveToyDetails(Toy toy) {
		logger.info("Inside saveToy service...");
		toyRepository.save(toy);
		logger.info("Toy details are saved!!!");
		logger.info("Outside saveToyDetails method...");
	}
	
	public List<Toy> findAll(){
		logger.info("Inside findAll service method...");
		List<Toy> toys = (List<Toy>) toyRepository.findAll();
		logger.info("Outside findAll service method...");
		return toys;
	}

	@Override
	public Optional<Toy> findById(Long id) {
		logger.info("Inside findByID service method...");
		return toyRepository.findById(id);
	}

}

/**
 * 
 */
package com.exsgi.api;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author SUNIL NAYAK
 *
 */
@Service
@Transactional
public class StoreServiceImpl implements StoreService{
	
	private static Logger logger = LoggerFactory.getLogger(StoreServiceImpl.class);
	@Autowired
	private StoreRepository storeRepository;
	
	
	@Override
	public Store saveStore(Store store) {
		logger.info("Inside saveStore service method...");
		return storeRepository.save(store);
		
	}


	@Override
	public List<Store> findAll() {
		logger.info("Inside findAllStore method...");
		List<Store> stores = (List<Store>) storeRepository.findAll();
		logger.info("Outside findAllStore method...");
		return stores;
	}


	@Override
	public Optional<Store> findById(Long id) {
		logger.info("Inside findById service method...");
		return storeRepository.findById(id);
	}

}

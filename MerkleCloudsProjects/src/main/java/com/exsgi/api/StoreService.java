/**
 * 
 */
package com.exsgi.api;

import java.util.List;
import java.util.Optional;

/**
 * @author SUNIL NAYAK
 *
 */
public interface StoreService {
	
	public Store saveStore(Store store);
	public List<Store> findAll();
	public Optional<Store> findById(Long id);
}

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
public interface ToyService {
	public void saveToyDetails(Toy toy);
	public List<Toy> findAll();
	public Optional<Toy> findById(Long id);
}

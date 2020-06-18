/**
 * 
 */
package com.exsgi.api;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author SUNIL NAYAK
 *
 */
@Repository
public interface ToyRepository extends CrudRepository<Toy, Long>{

}

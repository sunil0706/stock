/**
 * 
 */
package com.visel.bookstore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.visel.bookstore.model.Book;

/**
 * @author sunilnayak
 *
 */
@Repository
public interface BookStoreRepository extends JpaRepository<Book, Long>{
	
	public Optional<Book> findByIsbn(Integer id);
	
	public List<Book> searchByTitle(String string);
}

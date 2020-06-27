/**
 * 
 */
package com.visel.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.visel.bookstore.model.Book;

/**
 * @author sunilnayak
 *
 */
public interface BookStoreService {
	
	public ResponseEntity<Object> saveBook(Book book);
	
	public List<Book> findAllBooks();
	
	public Optional<Book> findBookById(Long id);
}

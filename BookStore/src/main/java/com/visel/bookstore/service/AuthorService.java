/**
 * 
 */
package com.visel.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.visel.bookstore.model.Author;

/**
 * @author sunilnayak
 *
 */
public interface AuthorService {
	
public ResponseEntity<Object> saveAuthor(Author author);
	
	public List<Author> findAllAuthors();
	
	public Optional<Author> findAuthorById(Long id);
	
	public ResponseEntity<Object> updateAuthorById(Author author, Long id);
	
	public ResponseEntity<Object> deleteAuthor(Long id);
	
	
}

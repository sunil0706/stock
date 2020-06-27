/**
 * 
 */
package com.visel.bookstore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.visel.bookstore.model.Author;
import com.visel.bookstore.repository.AuthorRepository;
import com.visel.bookstore.service.AuthorServiceImpl;

/**
 * @author sunilnayak
 *
 */
@RestController
public class AuthorController {
	
	private AuthorServiceImpl authorService;
	private AuthorRepository authorRepository;
	
	public AuthorController(AuthorServiceImpl authorService, AuthorRepository authorRepository) {
		this.authorService = authorService;
		this.authorRepository = authorRepository;
	}
	@PostMapping("/author")
	public ResponseEntity<Object> saveAuthor(@RequestBody Author authors) {
		authorService.saveAuthor(authors);
		return new ResponseEntity<> (HttpStatus.CREATED);
	
	}
}

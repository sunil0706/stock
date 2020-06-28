/**
 * 
 */
package com.visel.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.visel.bookstore.model.Author;
import com.visel.bookstore.service.AuthorServiceImpl;

/**
 * @author sunilnayak
 *
 */
@RestController
public class AuthorController {
	
	@Autowired
	private AuthorServiceImpl authorService;
	
	
	@PostMapping("/author")
	public ResponseEntity<Object> saveAuthor(@RequestBody Author author) {
		authorService.saveAuthor(author);
		return new ResponseEntity<> (HttpStatus.CREATED);
	
	}
	
	@GetMapping("/author/{id}")
    public Author findAuthorById(@PathVariable Long id) {
        if(authorService.findAuthorById(id).isPresent())
            return authorService.findAuthorById(id).get();
        else return null;
    }
    @GetMapping("/author/findAllAuthors")
    public List<Author> findAllAuthors() {
        return authorService.findAllAuthors();
    }
    
	@DeleteMapping("/author/delete/{id}")
    public ResponseEntity<Object> deleteAuthorById(@PathVariable Long id) {
        return authorService.deleteAuthor(id);
    }
    
    @PutMapping("/author/update/{id}")
    public ResponseEntity<Object> updateAuthorById(@RequestBody Author author, @PathVariable Long id) {
        return authorService.updateAuthorById(author, id);
    }
}

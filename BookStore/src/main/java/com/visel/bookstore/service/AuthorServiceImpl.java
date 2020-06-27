/**
 * 
 */
package com.visel.bookstore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.visel.bookstore.model.Author;
import com.visel.bookstore.model.Book;
import com.visel.bookstore.repository.AuthorRepository;
import com.visel.bookstore.repository.BookStoreRepository;

/**
 * @author sunilnayak
 *
 */
@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private BookStoreRepository bookRepository;
	
	@Autowired
	private AuthorRepository authorRepository;
	
	public AuthorServiceImpl(BookStoreRepository bookRepository, AuthorRepository authorRepository) {
		this.bookRepository = bookRepository;
		this.authorRepository = authorRepository;
	}
	/** Create a new author  */
    @Transactional
    public ResponseEntity<Object> saveAuthor(Author author)  {

        Author newAuthor = new Author();
        //newAuthor.setAuthor(author.getAuthor());
        
        List<Author> authorList = new ArrayList<>();
        authorList.add(newAuthor);
        
        return ResponseEntity.ok("Successfully created Author");
    }
    
	@Override
	public List<Author> findAllAuthors() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Optional<Author> findAuthorById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}

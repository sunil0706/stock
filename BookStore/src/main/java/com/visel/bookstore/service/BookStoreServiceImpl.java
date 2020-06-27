/**
 * 
 */
package com.visel.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.visel.bookstore.model.Book;
import com.visel.bookstore.repository.BookStoreRepository;

/**
 * @author sunilnayak
 *
 */
@Service
public class BookStoreServiceImpl implements BookStoreService {

	private static Logger logger = LoggerFactory.getLogger(BookStoreServiceImpl.class);
	
	@Autowired
	private BookStoreRepository bookStoreRepository;
	
	 /** Create a new Book */
	
	@Override
	public ResponseEntity<Object> saveBook(Book book) {
		
		Book newBook = new Book();
		
	        if (bookStoreRepository.findByIsbn(book.getIsbn()).isPresent()) {
	            return ResponseEntity.badRequest().body("The Book is already Present, Failed to save new book");
	        } else {
	            newBook.setCategory(book.getCategory());
	            newBook.setIsbn(book.getIsbn());
	            newBook.setTitle(book.getTitle());
	            newBook.setYear(book.getYear());
	            newBook.setPrice(book.getPrice());
	            newBook.setAuthors(book.getAuthors());
	            
	            Book savedBook = bookStoreRepository.save(newBook);
	            
	            if (bookStoreRepository.findById(savedBook.getId()).isPresent())
	                return ResponseEntity.ok("Book Saved Successfully");
	            
	            else
	            	return ResponseEntity.unprocessableEntity().body("Failed Saving Book as Specified");
	        }
	}

	@Override
	public List<Book> findAllBooks() {
		List<Book> books = (List<Book>) bookStoreRepository.findAll();
		return books;
	}
	
	@Override
	public Optional<Book> findBookById(Long id) {
		logger.info("Inside findBookById service method");
		logger.info("Id : "+id);
		Optional<Book> book = bookStoreRepository.findById(id);
		return book;
	}

}
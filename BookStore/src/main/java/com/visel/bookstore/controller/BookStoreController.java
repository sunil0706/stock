/**
 * 
 */
package com.visel.bookstore.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.visel.bookstore.model.Book;
import com.visel.bookstore.repository.BookStoreRepository;
import com.visel.bookstore.service.AuthorServiceImpl;
import com.visel.bookstore.service.BookStoreServiceImpl;

/**
 * @author sunilnayak
 *
 */
@RestController
public class BookStoreController {
	
	private static Logger logger = LoggerFactory.getLogger(BookStoreController.class);
	
	private BookStoreServiceImpl bookStoreService;
	private BookStoreRepository bookStoreRepository;
	
	public BookStoreController(BookStoreServiceImpl bookStoreService, BookStoreRepository bookStoreRepository) {
		this.bookStoreService = bookStoreService;
		this.bookStoreRepository = bookStoreRepository;
	}
	
	@PostMapping//(produces = MediaType.APPLICATION_XML_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
	@RequestMapping("/book")
	public ResponseEntity<Book> saveBook(@RequestBody Book book) {
		logger.info("Inside saveBookStore controller class");
		bookStoreService.saveBook(book);
		logger.info("Outside saveBookStore controller class");
		return new ResponseEntity<> (HttpStatus.CREATED);
	}
	
	@GetMapping//(produces = MediaType.APPLICATION_XML_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)	
	@RequestMapping("/findAllBooks")
	@ResponseBody
	public List<Book> findAllBook(){
		logger.info("Inside findAllBooks method...");
		List<Book> books = bookStoreService.findAllBooks();
		books.forEach(System.out::println);
		return books;
	}
	
	@GetMapping//(produces = MediaType.APPLICATION_XML_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)	
	@RequestMapping("/findBooksById/{id}")
				@ResponseBody
	public Optional<Book> findBookById(@PathVariable Long id){
					logger.info("Inside findBookById method...");
					Optional<Book> book = bookStoreService.findBookById(id);
					return book;
	}
	
	
}
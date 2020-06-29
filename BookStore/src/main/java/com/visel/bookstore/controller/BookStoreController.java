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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.visel.bookstore.model.Book;
import com.visel.bookstore.service.BookStoreServiceImpl;

/**
 * @author sunilnayak
 *
 */
@RestController
public class BookStoreController {

	private static Logger logger = LoggerFactory.getLogger(BookStoreController.class);
	@Autowired
	
	private BookStoreServiceImpl bookStoreService;

	@PostMapping
	@RequestMapping("/book")
	public ResponseEntity<Book> saveBook(@RequestBody Book book) {
		logger.info("Inside saveBookStore controller class");
		bookStoreService.saveBook(book);
		logger.info("Outside saveBookStore controller class");
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping
	@RequestMapping("book/findAllBooks")
	@ResponseBody
	public List<Book> findAllBook() {
		logger.info("Inside findAllBook method...");
		List<Book> books = bookStoreService.findAllBooks();
		books.forEach(System.out::println);
		logger.info("Outside findAllBook method...");
		return books;
	}

	@GetMapping
	@RequestMapping("/book/findBooksById/{id}")
	@ResponseBody
	public Optional<Book> findBookById(@PathVariable Long id) {
		logger.info("Inside findBookById method...");
		Optional<Book> book = bookStoreService.findBookById(id);
		return book;
	}

	@PutMapping("/book/update/{id}")
	public ResponseEntity<Object> updateBook(@PathVariable Long id, @RequestBody Book book) {
		return bookStoreService.updateBookById(book, id);
	}

	@DeleteMapping("/book/delete/{id}")
	public ResponseEntity<Object> deleteBook(@PathVariable Long id) {
		return bookStoreService.deleteBook(id);
	}
	
	@GetMapping("/book/searchBook/{keyword}")
	public List<Book> searchBook(@PathVariable String keyword) {
		logger.info("Inside searchBook controller");
		List<Book> books = bookStoreService.searchByTitle(keyword);
		books.forEach(System.out::println);
		return books;
	}
	
}
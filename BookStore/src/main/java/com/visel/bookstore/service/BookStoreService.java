/**
 * 
 */
package com.visel.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.visel.bookstore.model.Book;
import com.visel.bookstore.model.BookModel;
import com.visel.bookstore.model.Bookstore;

/**
 * @author sunilnayak
 *
 */
public interface BookStoreService {
	
	public ResponseEntity<Object> saveBook(Book book);
	
	public List<Book> findAllBooks();
	
	public Optional<Book> findBookById(Long id);
	
	public ResponseEntity<Object> updateBookById(Book book);
	
	public ResponseEntity<Object> deleteBook(Long id);
	
	public List<Book> searchByTitle(String keyword);
	
	public List<BookModel > getBooks();
	
	public BookModel getBook(Long id);
	
	public ResponseEntity<Object> saveXMLObject(Bookstore bookstore);
}
